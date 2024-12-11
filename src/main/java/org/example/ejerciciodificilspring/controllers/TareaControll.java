package org.example.ejerciciodificilspring.controllers;


import org.example.ejerciciodificilspring.entities.Tarea;
import org.example.ejerciciodificilspring.services.TareaService;
import org.example.ejerciciodificilspring.services.TrabajadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
@Controller
@RequestMapping("/tarea")
public class TareaControll {
    private final TareaService tareaService;
    private final TrabajadorService trabajadorService;

    public TareaControll(TareaService tareaService, TrabajadorService trabajadorService) {
        this.tareaService = tareaService;
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public String listaTareas(Model model) {
        model.addAttribute("tareas", tareaService.findAll());
        return "tarea/list";
    }

    @GetMapping("/create")
    public String createTarea(Model model) {
        Tarea tarea = new Tarea();
        model.addAttribute("tarea", tarea);
        model.addAttribute("trabajadores", trabajadorService.findAll());
        model.addAttribute("tipos", tarea.getTipo());
        model.addAttribute("estados", tarea.getStatus());
        return "tarea/create";
    }

    @PostMapping("/create")
    public String createTarea(@ModelAttribute Tarea tarea, BindingResult result) {
        if (result.hasErrors()) {
            return "tarea/create";
        }
        tareaService.save(tarea);
        return "redirect:/tarea";
    }


    @PostMapping("/modificar")
    public String modificarTarea(@ModelAttribute Tarea tarea, BindingResult result) {
        if (result.hasErrors()) {
            return "tarea/update";
        }
        tareaService.save(tarea);
        return "redirect:/tarea";
    }

    @GetMapping("/{id}")
    public String tareaDetallada(Model model, @PathVariable long id){
        model.addAttribute("tarea", tareaService.findById(id));
        return "tarea/taD";
    }
}
