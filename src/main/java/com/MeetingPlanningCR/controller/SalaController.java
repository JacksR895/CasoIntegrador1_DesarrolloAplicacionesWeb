package com.MeetingPlanningCR.controller;

import com.MeetingPlanningCR.domain.Sala;
import com.MeetingPlanningCR.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;


    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping("/listado")
    public String listado(Model model){
        model.addAttribute("salas", salaService.getSalas()); //igual mando al modelo todo los listados.
        model.addAttribute("sala",new Sala()); //para poder tambien crear una sala nueva.
        return "sala/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Sala sala, RedirectAttributes redirectAttributes){
            salaService.save(sala);
            redirectAttributes.addFlashAttribute("todoOk", "Sala guardada");
            return "redirect:/salas/listado";
    }

}
