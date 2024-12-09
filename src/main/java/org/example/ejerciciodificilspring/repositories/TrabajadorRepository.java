package org.example.ejerciciodificilspring.repositories;

import org.example.ejerciciodificilspring.entities.Equipo;
import org.example.ejerciciodificilspring.entities.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
}
