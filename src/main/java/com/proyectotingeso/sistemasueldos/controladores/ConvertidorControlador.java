package com.proyectotingeso.sistemasueldos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ConvertidorControlador {

    public int getAnnoFecha(String fecha){
        String[] arreglo = fecha.split("/");
        int anno = Integer.valueOf(arreglo[0]);
        return anno;
    }

    public int getMesFecha(String fecha){
        String[] arreglo = fecha.split("/");
        int mes = Integer.valueOf(arreglo[1]);
        return mes;
    }

    public int getDiaFecha(String fecha){
        String[] arreglo = fecha.split("/");
        int dia = Integer.valueOf(arreglo[2]);
        return dia;
    }

    public int getHora(String hora){
        String[] arreglo = hora.split(":");
        int horav = Integer.valueOf(arreglo[0]);
        return horav;
    }

    public int getMinutos(String hora){
        String[] arreglo = hora.split(":");
        int minutos = Integer.valueOf(arreglo[1]);
        return minutos;
    }
}
