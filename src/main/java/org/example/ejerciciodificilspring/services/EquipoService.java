package org.example.ejerciciodificilspring.services;


import org.example.ejerciciodificilspring.entities.Equipo;
import org.example.ejerciciodificilspring.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;



    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Equipo findById(Long id) {
        return equipoRepository.findById(id).orElse(null);


    }
    public void save(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    public void delete(Equipo equipo) {
        equipoRepository.delete(equipo);
    }


}
