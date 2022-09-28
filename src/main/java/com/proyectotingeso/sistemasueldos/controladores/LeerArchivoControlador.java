package com.proyectotingeso.sistemasueldos.controladores;

import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class LeerArchivoControlador {

    public ArrayList<String> leerData() throws FileNotFoundException {
        
        return arreglo_strings;
    }
    public String[] splitString(String string){
        String arreglo_strings[];
        arreglo_strings = string.split(";");
        return arreglo_strings;
    }
     public String obtenerFecha(String[] arreglo){
        String fecha = arreglo[0];
        return fecha;
     }

     public String obtenerHora(String[] arreglo){
        String hora = arreglo[1];
        return hora;
     }

     public String obtenerRut(String[] arreglo){
        String rut = arreglo[2];
        return rut;
     }

}
