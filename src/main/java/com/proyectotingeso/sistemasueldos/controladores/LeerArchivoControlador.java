package com.proyectotingeso.sistemasueldos.controladores;

import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.ArrayList;


@Controller
public class LeerArchivoControlador {

    public ArrayList<String[]> leerData() throws IOException {
        String path = "/data.txt";
        System.out.println("Voy a leer el archivo " + path);
        String line = "";
        ArrayList<String[]> arreglo_strings = new ArrayList<String[]>();
        int i = 0;
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(path));
            while((line = buffer.readLine()) != null){
                String[] linea = line.split(";");
                System.out.println("Fecha " + linea[0] + "Hora " + linea[1] + "Rut " + linea[2]);
                arreglo_strings.add(i,linea);
            }
            buffer.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
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
