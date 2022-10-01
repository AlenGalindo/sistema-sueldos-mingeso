package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sobretiempo")
@NoArgsConstructor
@AllArgsConstructor
public class SobretiempoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int categoria;
    private int monto;

    public int getCategoria() {
        return categoria;
    }

    public int getMonto() {
        return monto;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
