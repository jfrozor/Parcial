package com.example.parcial.Repository;


import com.example.parcial.Model.Jugador;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> findJugadoresByEquipo(@Param("idEquipo") int idEquipo);

    @Query(value = """
        SELECT j.* 
        FROM jugador j
        JOIN estadisticajugador e ON j.id_jugador = e.id_jugador
        GROUP BY j.id_jugador
        HAVING SUM(e.goles) > :minGoles
    """, nativeQuery = true)
    List<Jugador> findJugadoresConMasDeXGoles(@Param("minGoles") int minGoles);
}
