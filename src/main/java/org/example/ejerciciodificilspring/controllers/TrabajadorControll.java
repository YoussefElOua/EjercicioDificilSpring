package org.example.ejerciciodificilspring.controllers;

import org.example.ejerciciodificilspring.entities.Trabajador;
import org.example.ejerciciodificilspring.services.EquipoService;
import org.example.ejerciciodificilspring.services.TareaService;
import org.example.ejerciciodificilspring.services.TrabajadorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;


@Controller
@RequestMapping("/trabajador")
public class TrabajadorControll {

    private final TrabajadorService trabajadorService;
    private final EquipoService equipoService;
    private final TareaService tareaService;

    public TrabajadorControll(EquipoService equipoService, TareaService tareaService,TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
        this.equipoService = equipoService;
        this.tareaService = tareaService;

    }

    @GetMapping
    public String listaTrabajadores(Model model) {
        model.addAttribute("trabajadores", trabajadorService.findAll());
        return "trabajador/list";
    }

    @GetMapping("/create")
    public String createTrabajador(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        model.addAttribute("equipos", equipoService.findAll());
        model.addAttribute("tareas", tareaService.findAll());
        return "trabajador/create";
    }

    @PostMapping("/create")
    public String createTrabajador(@ModelAttribute Trabajador trabajador) {
        trabajadorService.save(trabajador);
        return "redirect:/trabajador";
    }

    @GetMapping("/modificar/{id}")
    public String modificarTrabajador(@PathVariable long id, Model model) {
        Trabajador trabajador = trabajadorService.findById(id);
        trabajador.setEquipo(null);
        trabajador.setTareas(new HashSet<>());
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("equipos", equipoService.findAll());
        model.addAttribute("tareas", tareaService.findAll());
        return "trabajador/update";
    }

    @PostMapping("/modificar/{id}")
    public String modificarTrabajador(@PathVariable long id, @ModelAttribute Trabajador trabajador) {
        trabajador.setId(id);
        trabajadorService.save(trabajador);
        return "redirect:/trabajador";
    }

    @GetMapping("/{id}")
    public String trabajadorDetallado(@PathVariable long id, Model model){
        model.addAttribute("trabajador", trabajadorService.findById(id));
        return "trabajador/tD";
    }
}
