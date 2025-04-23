package com.example.parcial.Service;

import com.example.parcial.Model.EstadisticaJugador;
import com.example.parcial.Repository.EstadisticaJugadorRepository;
import com.example.parcial.Exception.RecursoNoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadisticaJugadorService {

    private final EstadisticaJugadorRepository estadisticaJugadorRepository;

    public List<EstadisticaJugador> listar() {
        return estadisticaJugadorRepository.findAll();
    }

    public EstadisticaJugador obtenerPorId(int id) {
        return estadisticaJugadorRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estadística no encontrada con ID: " + id));
    }

    public EstadisticaJugador guardar(EstadisticaJugador estadistica) {
        return estadisticaJugadorRepository.save(estadistica);
    }

    public EstadisticaJugador actualizar(int id, EstadisticaJugador actualizado) {
        EstadisticaJugador existente = obtenerPorId(id);
        existente.setMinutos_jugados(actualizado.getMinutos_jugados());
        existente.setGoles(actualizado.getGoles());
        existente.setAsistencias(actualizado.getAsistencias());
        existente.setTarjetas_amarillas(actualizado.getTarjetas_amarillas());
        existente.setTarjetas_rojas(actualizado.getTarjetas_rojas());
        existente.setJugador(actualizado.getJugador());
        existente.setPartido(actualizado.getPartido());
        return estadisticaJugadorRepository.save(existente);
    }

    public void eliminar(int id) {
        if (!estadisticaJugadorRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se puede eliminar: estadística con ID " + id + " no existe.");
        }
        estadisticaJugadorRepository.deleteById(id);
    }
}
