package org.example.ejerciciodificilspring.repositories;

import org.example.ejerciciodificilspring.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
