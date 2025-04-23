package com.example.parcial.Service;

import com.example.parcial.Model.Entrenador;
import com.example.parcial.Repository.EntrenadorRepository;
import com.example.parcial.Exception.RecursoNoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public List<Entrenador> listar() {
        return entrenadorRepository.findAll();
    }

    public Entrenador obtenerPorId(int id) {
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Entrenador no encontrado con ID: " + id));
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador actualizar(int id, Entrenador actualizado) {
        Entrenador existente = obtenerPorId(id);
        existente.setNombre(actualizado.getNombre());
        existente.setEspecialidad(actualizado.getEspecialidad());
        existente.setEquipo(actualizado.getEquipo());
        return entrenadorRepository.save(existente);
    }

    public void eliminar(int id) {
        if (!entrenadorRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No se puede eliminar: entrenador con ID " + id + " no existe.");
        }
        entrenadorRepository.deleteById(id);
    }
}
