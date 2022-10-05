package com.proyectotingeso.sistemasueldos.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculosControladorTest {

    CalculosControlador calculos = new CalculosControlador();
    @Test
    void getDescuentoAtraso() {
        int hora = 8;
        int minutos = 15;
        float descuentos = calculos.getDescuentoAtraso(hora,minutos);
        assertEquals(0.01f,descuentos,0.01);

        hora = 8;
        minutos = 26;
        descuentos = calculos.getDescuentoAtraso(hora,minutos);
        assertEquals(0.03f,descuentos,0.01);

        hora = 8;
        minutos = 55;
        descuentos = calculos.getDescuentoAtraso(hora,minutos);
        assertEquals(0.06f,descuentos,0.01);

        hora = 9;
        minutos = 15;
        descuentos = calculos.getDescuentoAtraso(hora,minutos);
        assertEquals(-1.0f,descuentos,0.0);

    }

    @Test
    void getBonosAnnosServicio() {

    }

    @Test
    void montoHorasExtra() {
        int hora_salida = 19;
        String categoria = "A";
        int monto_final = calculos.montoHorasExtra(hora_salida,categoria);
        assertEquals(25000,monto_final,0);

        hora_salida = 19;
        categoria = "B";
        monto_final = calculos.montoHorasExtra(hora_salida,categoria);
        assertEquals(20000,monto_final,0);

        hora_salida = 19;
        categoria = "C";
        monto_final = calculos.montoHorasExtra(hora_salida,categoria);
        assertEquals(10000,monto_final,0);

    }
}