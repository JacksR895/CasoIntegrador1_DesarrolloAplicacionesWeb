package com.MeetingPlanningCR.controller;


import com.MeetingPlanningCR.domain.Reunion;
import com.MeetingPlanningCR.service.ReunionService;
import com.MeetingPlanningCR.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reuniones")
public class ReunionController {

    private final ReunionService reunionService;
    private final SalaService salaService;

    public ReunionController(ReunionService reunionService, SalaService salaService) {
        this.reunionService = reunionService;
        this.salaService = salaService;
    }

    @GetMapping("/listado")
    public String listado(Model model){ // se genera modelo para guardar las reuniones y las salas y poder llamalas en las vistas.

        List<Reunion> reunionesLista = reunionService.getReuniones();

        model.addAttribute("reuniones", reunionesLista); // genero al modelo las reuniones para tener el historico.
        model.addAttribute("reunion",new Reunion());  // mando la posibilidad de generar nuevas reuniones
        model.addAttribute("salas", salaService.getSalas()); // traigo las salas generadas para que puedan ser llamadas en caso de las reuiones.
        return "reunion/listado";
    }

    @PostMapping("/guardar") // agregue validacion de reunion para salvar antes de usar guardar, y se llamada al lado despues de finalizar el guardado.
    public String guardar(@Valid Reunion reunion, RedirectAttributes redirectAttributes) {
        try{
            reunionService.save(reunion);
            redirectAttributes.addFlashAttribute("todoOk", "Reunion guardada");
        } catch (IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/reuniones/listado";
    }


}
