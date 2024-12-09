package org.example.ejerciciodificilspring.repositories;

import org.example.ejerciciodificilspring.entities.Equipo;
import org.example.ejerciciodificilspring.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
