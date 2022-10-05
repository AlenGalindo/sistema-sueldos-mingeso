package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.entidades.PlanillaEntidad;
import com.proyectotingeso.sistemasueldos.servicios.PlanillaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class PlanillaControlador {
    @Autowired
    PlanillaServicio planillaServicio;

    @GetMapping("/planillas")
    public String listarPlanillas(Model model){
        ArrayList<PlanillaEntidad> planillas = planillaServicio.getPlanillas();
        model.addAttribute("planillas",planillas);
        return "planilla_index";
    }

    @GetMapping("/planillas/calcular")
    public String calcularplanillas(){
        System.out.println("Antes de entrar a crear las planillas");
        planillaServicio.crearPlanillas();
        System.out.println("Sali de crear las planillas");
        return "redirect:/planillas";
    }
}
