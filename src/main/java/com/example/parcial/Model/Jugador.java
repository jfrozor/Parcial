package com.example.parcial.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jugador;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String posicion;

    @Column
    @NonNull
    private int dorsal;

    @Column
    @NonNull
    private Date fecha_nac;

    @Column
    @NonNull
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<EstadisticaJugador> estadisticas;

}

