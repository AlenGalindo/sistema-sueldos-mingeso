package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;

@Entity
@Table(name = "bono")
public class BonoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int  limite_inferior;
    private int limite_superior;
    private float porcentaje;

    public int getId() {
        return id;
    }

    public int getLimite_inferior() {
        return limite_inferior;
    }

    public int getLimite_superior() {
        return limite_superior;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setLimite_inferior(int limite_inferior) {
        this.limite_inferior = limite_inferior;
    }
    public void setLimite_superior(int limite_superior) {
        this.limite_superior = limite_superior;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
}
