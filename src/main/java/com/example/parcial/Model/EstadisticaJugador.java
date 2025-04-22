package com.example.parcial.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="estadisticajugador")


public class EstadisticaJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estadistica;

    @Column
    @NonNull
    private int id_jugador;

    @Column
    @NonNull
    private int id_partido;

    @Column
    @NonNull
    private int minutos_jugados;

    @Column
    @NonNull
    private int goles;

    @Column
    @NonNull
    private int asistencias;

    @Column
    @NonNull
    private int tarjetas_amarillas;

    @Column
    @NonNull
    private int tarjetas_rojas;


    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;

}
