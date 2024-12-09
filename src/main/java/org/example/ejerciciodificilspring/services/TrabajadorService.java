package org.example.ejerciciodificilspring.services;

import org.example.ejerciciodificilspring.entities.Trabajador;
import org.example.ejerciciodificilspring.repositories.EquipoRepository;
import org.example.ejerciciodificilspring.repositories.TareaRepository;
import org.example.ejerciciodificilspring.repositories.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;
    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private TareaRepository tareaRepository;

    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador findById(long id) {
        return trabajadorRepository.findById(id).orElse(null);
    }
}