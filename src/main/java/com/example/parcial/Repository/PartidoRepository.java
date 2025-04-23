package com.example.parcial.Repository;

import com.example.parcial.Model.Partido;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    @Query(value = """
        SELECT 
            SUM(CASE 
                WHEN p.equipo_local = :idEquipo THEN p.goles_local
                WHEN p.equipo_visita = :idEquipo THEN p.goles_visita
                ELSE 0 END) AS total_goles
        FROM partido p
        WHERE p.equipo_local = :idEquipo OR p.equipo_visita = :idEquipo
    """, nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("idEquipo") int idEquipo);

    @Query(value = """
        SELECT 
            p.id_partido,
            el.nombre AS equipo_local,
            ev.nombre AS equipo_visita,
            p.goles_local,
            p.goles_visita,
            p.fecha,
            p.estadio
        FROM partido p
        JOIN equipo el ON p.equipo_local = el.id_equipo
        JOIN equipo ev ON p.equipo_visita = ev.id_equipo
        ORDER BY p.fecha DESC
    """, nativeQuery = true)
    List<Map<String, Object>> obtenerResultadosPartidos();
}
