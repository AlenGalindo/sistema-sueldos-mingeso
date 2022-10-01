package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.entidades.AutorizacionEntidad;
import com.proyectotingeso.sistemasueldos.servicios.AutorizacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class AutorizacionControlador {
    @Autowired
    AutorizacionServicio autorizacionServicio;

    @GetMapping("/autorizaciones")
    public String listarAutorizaciones(Model model){
        ArrayList<AutorizacionEntidad> autorizaciones = autorizacionServicio.getAutorizaciones();
        model.addAttribute("autorizaciones",autorizaciones);
        return "autorizacion_index";
    }

    @GetMapping("/autorizaciones/crear")
    public String agregar(Model model){
        model.addAttribute("autorizacion",new AutorizacionEntidad());
        return "autorizacion_crear";
    }

    @PostMapping("/autorizaciones/guardar")
    public String guardar(AutorizacionEntidad a, Model model){
        autorizacionServicio.saveAutorizacion(a);
        return "redirect:/autorizaciones";
    }
}
