package com.example.parcial.Controller;

import com.example.parcial.Model.Entrenador;
import com.example.parcial.Repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorRepository entrenadorRepository;

    @GetMapping
    public List<Entrenador> listar() {
        return entrenadorRepository.findAll();
    }
}
