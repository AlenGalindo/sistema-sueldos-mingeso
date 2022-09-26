package com.proyectotingeso.sistemasueldos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeControlador {

    @GetMapping("/")
    public String mostrarHome(){
        return "home";
    }
}
