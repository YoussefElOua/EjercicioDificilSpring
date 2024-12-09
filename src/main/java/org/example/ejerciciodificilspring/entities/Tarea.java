package org.example.ejerciciodificilspring.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor


@Entity
@Table(name="tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = true)
    private String description;

    @Column(name="startDate", nullable = false)
    private LocalDate startDate;

    @Column(name="endDate", nullable = false)
    private LocalDate endDate;

    @Column(name="type", nullable = false)
    private String type;



    @Column(name="status", nullable = false)
    private String status;



    @ManyToMany(mappedBy = "tareas")
    private Set<Trabajador> trabajadores = new HashSet<>();
}
