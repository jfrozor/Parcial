package com.example.parcial.Service;

import com.example.parcial.Model.Equipo;
import com.example.parcial.Repository.EquipoRepository;
import com.example.parcial.Exception.RecursoNoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }

    public Equipo obtenerPorId(int id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Equipo no encontrado con ID: " + id));
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo actualizar(int id, Equipo equipoActualizado) {
        Equipo equipo = obtenerPorId(id);
        equipo.setNombre(equipoActualizado.getNombre());
        equipo.setCiudad(equipoActualizado.getCiudad());
        equipo.setFundacion(equipoActualizado.getFundacion());
        return equipoRepository.save(equipo);
    }

    public void eliminar(int id) {
        if (!equipoRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se puede eliminar: equipo con ID " + id + " no existe.");
        }
        equipoRepository.deleteById(id);
    }
}
