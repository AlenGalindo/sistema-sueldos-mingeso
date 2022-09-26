package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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
    @GetMapping("/asistencias/editar/{id}")
    public String editarAsistencia(@PathVariable("id") Integer id, Model model){
        Optional<AsistenciaEntidad> asistencia = asistenciaServicio.getById(id);
        model.addAttribute("asistencia",asistencia);
        return "asistencia_editar";
    }
    @PostMapping("/asistencias/actualizar/{id}")
    public String actualizarAsistencia(@PathVariable("id") Long id, AsistenciaEntidad asistencia, Model model){
        asistenciaServicio.saveAsistencia(asistencia);
        return "redirect:asistencias_index";
    }
}
