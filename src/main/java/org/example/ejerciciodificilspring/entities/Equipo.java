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
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre" , nullable = false)
    private String nombre;


    @OneToMany //hacia trabajador
    @JoinColumn(name = "equipo_id")
    private Set<Trabajador> trabajadores = new HashSet<>();


}
