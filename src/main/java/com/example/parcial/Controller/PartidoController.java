package com.example.parcial.Controller;

import com.example.parcial.Repository.PartidoRepository;
import com.example.parcial.Model.Partido;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partidos")
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoRepository partidoRepository;

    @GetMapping
    public List<Partido> listar() {
        return partidoRepository.findAll();
    }

    // Obtener total de goles de un equipo
    @GetMapping("/total-goles/{idEquipo}")
    public Integer totalGolesEquipo(@PathVariable int idEquipo) {
        return partidoRepository.totalGolesPorEquipo(idEquipo);
    }

    // Obtener resultados con nombres de equipos
    @GetMapping("/resultados")
    public List<Map<String, Object>> resultados() {
        return partidoRepository.obtenerResultadosPartidos();
    }
}
