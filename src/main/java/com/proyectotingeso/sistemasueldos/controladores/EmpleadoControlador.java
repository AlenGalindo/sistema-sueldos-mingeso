package com.proyectotingeso.sistemasueldos.controladores;


import com.proyectotingeso.sistemasueldos.entidades.EmpleadoEntidad;
import com.proyectotingeso.sistemasueldos.servicios.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class EmpleadoControlador {
    @Autowired
    EmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        ArrayList<EmpleadoEntidad> empleado = empleadoServicio.getEmpleados();
        model.addAttribute("empleado",empleado);
        return "empleado_index";
    }

}
