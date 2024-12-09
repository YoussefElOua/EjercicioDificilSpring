package org.example.ejerciciodificilspring.controllers;

import org.example.ejerciciodificilspring.entities.Equipo;
import org.example.ejerciciodificilspring.services.EquipoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipos")
public class EquipoControll {
    private final EquipoService equipoService ;

    public EquipoControll(EquipoService authorService) {
        this.equipoService = authorService;
    }


    @GetMapping
    public String listEquipos(Model model) {
        model.addAttribute("equipos", equipoService.findAll());
        return "equipos/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "equipos/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Equipo equipo) {

        return "redirect:/equipos";
    }
}
