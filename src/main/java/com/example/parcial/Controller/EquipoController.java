package com.example.parcial.Controller;

import com.example.parcial.Model.Equipo;
import com.example.parcial.Repository.EquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoRepository equipoRepository;

    @GetMapping
    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }
}
