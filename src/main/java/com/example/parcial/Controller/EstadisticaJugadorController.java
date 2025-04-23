package com.example.parcial.Controller;

import com.example.parcial.Model.EstadisticaJugador;
import com.example.parcial.Repository.EstadisticaJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@RequiredArgsConstructor
public class EstadisticaJugadorController {

    private final EstadisticaJugadorRepository estadisticaJugadorRepository;

    @GetMapping
    public List<EstadisticaJugador> listar() {
        return estadisticaJugadorRepository.findAll();
    }
}
