package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping
public class AsistenciaControlador {
    @Autowired
    AsistenciaServicio asistenciaServicio;
    @Autowired
    LeerArchivoControlador leerArchivoControlador;
    @GetMapping("/asistencias")
    public String listarAsistencias(Model model){
        ArrayList<AsistenciaEntidad> asistencias = asistenciaServicio.getAsistencias();
        model.addAttribute("asistencias",asistencias);
        return "asistencia_index";
    }

    @GetMapping("/asistencias/cargar")
    public String cargarData() throws IOException {
        ArrayList<String[]> asistencias = leerArchivoControlador.leerData();
        for (String[] asistencia: asistencias)
        {
            AsistenciaEntidad asistenciaEntidad = new AsistenciaEntidad();
            asistenciaEntidad.setFecha(asistencia[0]);
            asistenciaEntidad.setHora(asistencia[1]);
            asistenciaEntidad.setRut(asistencia[2]);
            asistenciaServicio.saveAsistencia(asistenciaEntidad);
        }
        return "redirect:/asistencias";
    }
}
