package org.example.ejerciciodificilspring.controllers;

import org.example.ejerciciodificilspring.entities.Equipo;
import org.example.ejerciciodificilspring.services.EquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipo")
public class EquipoControll {
    private final EquipoService equipoService;

    public EquipoControll(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public String listaEquipos(Model model) {
        model.addAttribute("equipos", equipoService.findAll());
        return "equipo/list";
    }

    @GetMapping("/create")
    public String createEquipo(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "equipo/create";
    }

    @PostMapping("/create")
    public String createEquipo(@ModelAttribute Equipo equipo) {
        equipoService.save(equipo);
        return "redirect:/equipo";
    }

    @GetMapping("/modificar/{id}")
    public String modificarEquipo(@PathVariable long id, Model model) {
        model.addAttribute("equipo", equipoService.findById(id));
        return "equipo/update";
    }

    @PostMapping("/update")
    public String updateEquipo(@ModelAttribute Equipo equipo) {
        equipoService.update(equipo);
        return "redirect:/equipo";
    }

    @GetMapping("/{id}")
    public String equipoDetallado(@PathVariable long id, Model model){
        model.addAttribute("equipo", equipoService.findById(id));
        return "equipo/eD";
    }
}
