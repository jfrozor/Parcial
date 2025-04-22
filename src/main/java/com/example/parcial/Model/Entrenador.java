package com.example.parcial.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entrenador;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String especialidad;

    @Column
    @NonNull
    private int id_equipo;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

}
