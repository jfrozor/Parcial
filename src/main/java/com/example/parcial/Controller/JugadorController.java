package com.example.parcial.Controller;

import com.example.parcial.Model.Jugador;
import com.example.parcial.Repository.JugadorRepository;
import com.example.parcial.Service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorService jugadorService;

    @GetMapping
    public List<Jugador> listar() {
        return jugadorService.listar();
    }

    @GetMapping("/{id}")
    public Jugador obtenerPorId(@PathVariable int id) {
        return jugadorService.buscarPorId(id);
    }

    @GetMapping("/por-equipo/{idEquipo}")
    public List<Jugador> jugadoresPorEquipo(@PathVariable int idEquipo) {
        return jugadorService.buscarPorEquipo(idEquipo);
    }

    @GetMapping("/con-mas-goles")
    public List<Jugador> jugadoresConMasGoles(@RequestParam int minGoles) {
        return jugadorService.jugadoresConMasDeXGoles(minGoles);
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorService.guardar(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable int id, @RequestBody Jugador jugador) {
        return jugadorService.actualizar(id, jugador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        jugadorService.eliminar(id);
    }
}
