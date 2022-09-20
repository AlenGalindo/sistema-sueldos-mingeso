package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping
public class AsistenciaControlador {
    @Autowired
    AsistenciaServicio asistenciaServicio;
    @GetMapping("/asistencias")
    public String listarAsistencias(Model model){
        ArrayList<AsistenciaEntidad> asistencias = asistenciaServicio.getAsistencias();
        model.addAttribute("asistencias",asistencias);
        return "asistencia_index";
    }
    @PutMapping("/asistencias")
    public AsistenciaEntidad updateAsistencia(@RequestBody Model model){

    }
}
