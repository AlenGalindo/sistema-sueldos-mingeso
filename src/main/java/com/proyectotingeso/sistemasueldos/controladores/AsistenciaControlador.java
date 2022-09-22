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
    public String editarAsistencia(@PathVariable Long id, Model model){
        Optional<AsistenciaEntidad> asistencia = asistenciaServicio.getById(id);
        model.addAttribute("asistencia",asistencia);
        return "asistencia_editar";
    }
    @PutMapping("/asistencias/{id}")
    public String actualizarAsistencia(@PathVariable Long id, @ModelAttribute("asistencia") AsistenciaEntidad asistencia,Model model){
        Optional<AsistenciaEntidad> asistenciaExistente = asistenciaServicio.getById(id);
        asistenciaExistente.get().setId_asistencia(id);
        asistenciaExistente.get().setFecha(asistencia.getFecha());
        asistenciaExistente.get().setHora_entrada(asistencia.getHora_entrada());
        asistenciaExistente.get().setHora_salida(asistencia.getHora_salida());
        asistenciaExistente.get().setJustificativo(asistencia.getJustificativo());
        asistenciaExistente.get().setHoras_extra(asistencia.getHoras_extra());
        asistenciaExistente.get().setId_empleado(asistencia.getId_empleado());
        asistenciaServicio.saveAsistencia(asistenciaExistente.get());
        return "redirect:asistencias_index";
    }
}
