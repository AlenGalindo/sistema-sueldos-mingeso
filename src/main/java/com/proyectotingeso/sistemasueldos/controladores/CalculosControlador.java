package com.proyectotingeso.sistemasueldos.controladores;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class CalculosControlador {

    @Autowired
    ConvertidorControlador convertidorControlador;


    public float getDescuentoAtraso(int hora, int minutos){
        float descuento = 0.0f;
        if(hora == 8 && minutos > 0 && minutos < 25){
            descuento = 0.01f;
        } else if (hora == 8 && minutos > 25 && minutos < 45){
            descuento = 0.03f;
        } else if (hora == 8  && minutos > 45 && minutos < 60){
            descuento = 0.06f;
        } else if (hora > 8  && minutos > 10){
            descuento = -1.0f; //Significa inasistencia
        }
        return descuento;
    }

    public float descuentoPrevSalud(float sueldo_final){
        float sueldo = sueldo_final*(0.01f + 0.08f);
        return sueldo;
    }

    public float getBonosAnnosServicio(String fecha_contratacion){
        int anno_actual = LocalDate.now().getYear();
        float bono = 0f;
        int annos_servicio = anno_actual - convertidorControlador.getAnnoFecha(fecha_contratacion);
        if (annos_servicio > 5 && annos_servicio <= 9){
            bono = 0.05f;
        }else if (annos_servicio > 9 && annos_servicio <= 14){
            bono = 0.08f;
        }else if (annos_servicio > 14 && annos_servicio <= 19){
            bono = 0.11f;
        }else if (annos_servicio > 19 && annos_servicio <= 24){
            bono = 0.14f;
        }else if (annos_servicio > 25 ){
            bono = 0.17f;
        }
        return bono;
    }

    public int montoHorasExtra(int hora_salida, String categoria){
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("A");
        categorias.add("B");
        categorias.add("C");
        ArrayList<Integer> montos = new ArrayList<>();
        montos.add(25000);
        montos.add(20000);
        montos.add(10000);

        if (hora_salida > 18){
            int hora_extra = hora_salida - 18;
            int monto_final = hora_extra*montos.get(categorias.indexOf(categoria));
            return monto_final;
        }
        else{
            return 0;
        }
    }

    public float sueldoNoCot(int monto_horas_extra, float bono, float descuentos){
        ArrayList<String> categoria = new ArrayList<>();
        categoria.add("A");
        categoria.add("B");
        categoria.add("C");
        ArrayList<Integer> montos = new ArrayList<>();
        montos.add(1700000);
        montos.add(1200000);
        montos.add(800000);

        int sueldo_base = montos.get(categoria.indexOf(categoria));
        float sueldo = sueldo_base + monto_horas_extra + sueldo_base*bono - descuentos;
        return sueldo;
    }

    public float sueldo_liquido(float sueldo){
        float sueldo_final = sueldo - descuentoPrevSalud(sueldo);
        return sueldo_final;
    }

}