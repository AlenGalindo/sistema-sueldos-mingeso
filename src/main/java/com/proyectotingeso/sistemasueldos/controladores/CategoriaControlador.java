package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.entidades.CategoriaHoraExtraEntidad;
import com.proyectotingeso.sistemasueldos.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class CategoriaControlador {
    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        ArrayList<CategoriaHoraExtraEntidad> categoria = categoriaServicio.getCategorias();
        model.addAttribute("categoria",categoria);
        return "categoria_index";
    }

}