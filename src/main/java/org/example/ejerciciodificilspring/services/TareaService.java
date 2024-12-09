package org.example.ejerciciodificilspring.services;

import org.example.ejerciciodificilspring.entities.Tarea;
import org.example.ejerciciodificilspring.repositories.TareaRepository;
import org.example.ejerciciodificilspring.repositories.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;


    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea findById(long id) {
        return tareaRepository.findById(id).orElse(null);
    }
}
