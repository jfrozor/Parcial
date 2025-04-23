package com.example.parcial.Service;

import com.example.parcial.Exception.RecursoNoEncontradoException;
import com.example.parcial.Model.Jugador;
import com.example.parcial.Repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    // Listar todos
    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

    // Buscar por ID
    public Jugador buscarPorId(int id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Jugador no encontrado con ID: " + id));
    }

    // Buscar equipo
    public List<Jugador> buscarPorEquipo(int idEquipo) {
        return jugadorRepository.findJugadoresByEquipo(idEquipo);
    }

    // Buscar  goles
    public List<Jugador> jugadoresConMasDeXGoles(int minGoles) {
        if (minGoles < 0) {
            throw new IllegalArgumentException("El número de goles no puede ser negativo");
        }
        return jugadorRepository.findJugadoresConMasDeXGoles(minGoles);
    }

    // Guardar jugador
    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // Actualizar jugador
    public Jugador actualizar(int id, Jugador jugadorActualizado) {
        Jugador jugadorExistente = buscarPorId(id);

        jugadorExistente.setNombre(jugadorActualizado.getNombre());
        jugadorExistente.setDorsal(jugadorActualizado.getDorsal());
        jugadorExistente.setFecha_nac(jugadorActualizado.getFecha_nac());
        jugadorExistente.setNacionalidad(jugadorActualizado.getNacionalidad());
        jugadorExistente.setPosicion(jugadorActualizado.getPosicion());
        jugadorExistente.setEquipo(jugadorActualizado.getEquipo());

        return jugadorRepository.save(jugadorExistente);
    }

    // Eliminar jugador
    public void eliminar(int id) {
        if (!jugadorRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se puede eliminar: jugador con ID " + id + " no existe.");
        }
        jugadorRepository.deleteById(id);
    }
}
