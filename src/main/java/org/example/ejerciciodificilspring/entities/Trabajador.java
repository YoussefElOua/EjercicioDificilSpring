package org.example.ejerciciodificilspring.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

// Anotaciones Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor



@Entity
@Table(name="trabajadores")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="edad", nullable = false)
    private int edad;

    @ManyToOne()
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToMany
    @JoinTable(
            name = "Trabajador_Tarea",
            joinColumns = @JoinColumn(name = "trabajador_id"),
            inverseJoinColumns = @JoinColumn(name = "tarea_id")
    )
    private Set<Tarea> tareas = new HashSet<>();


}
