package com.example.parcial.Service;

import com.example.parcial.Model.Partido;
import com.example.parcial.Repository.PartidoRepository;
import com.example.parcial.Exception.RecursoNoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PartidoService {

    private final PartidoRepository partidoRepository;

    public List<Partido> listar() {
        return partidoRepository.findAll();
    }

    public Partido obtenerPorId(int id) {
        return partidoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Partido no encontrado con ID: " + id));
    }

    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido actualizar(int id, Partido actualizado) {
        Partido partido = obtenerPorId(id);
        partido.setFecha(actualizado.getFecha());
        partido.setEstadio(actualizado.getEstadio());
        partido.setEquipoLocal(actualizado.getEquipoLocal());
        partido.setEquipoVisita(actualizado.getEquipoVisita());
        partido.setGoles_local(actualizado.getGoles_local());
        partido.setGoles_visita(actualizado.getGoles_visita());
        return partidoRepository.save(partido);
    }

    public void eliminar(int id) {
        if (!partidoRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se puede eliminar: partido con ID " + id + " no existe.");
        }
        partidoRepository.deleteById(id);
    }

    public Integer totalGolesPorEquipo(int idEquipo) {
        return partidoRepository.totalGolesPorEquipo(idEquipo);
    }

    public List<Map<String, Object>> obtenerResultados() {
        return partidoRepository.obtenerResultadosPartidos();
    }
}

