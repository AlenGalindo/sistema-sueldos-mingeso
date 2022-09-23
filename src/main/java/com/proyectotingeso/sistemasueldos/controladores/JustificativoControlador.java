package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.entidades.JustificativoEntidad;
import com.proyectotingeso.sistemasueldos.servicios.JustificativoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
@RequestMapping
public class JustificativoControlador {
    @Autowired
    JustificativoServicio justificativoServicio;

    @GetMapping("/justificativos")
    public String listarJustificativos(Model model){
        ArrayList<JustificativoEntidad> justificativos = justificativoServicio.getJustificativos();
        model.addAttribute("justificativos",justificativos);
        return "justificativo_index";
    }
}
