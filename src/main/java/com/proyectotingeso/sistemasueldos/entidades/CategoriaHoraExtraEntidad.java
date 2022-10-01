package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;

@Entity
@Table(name = "categoria_hora_extra")
public class CategoriaHoraExtraEntidad {
    //Id unico del empleado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoria;
    private int monto_hora_extra;

    public String getCategoria() {
        return categoria;
    }

    public int getMonto_hora_extra() {
        return monto_hora_extra;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMonto_hora_extra(int monto_hora_extra) {
        this.monto_hora_extra = monto_hora_extra;
    }

}