package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "descuento")
public class DescuentoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //En minutos
    private int limite_inferior;
    private int limite_superior;
    private float monto;

    public int getLimite_inferior() {
        return limite_inferior;
    }

    public int getLimite_superior() {
        return limite_superior;
    }

    public float getMonto() {
        return monto;
    }

    public void setLimite_inferior(int limite_inferior) {
        this.limite_inferior = limite_inferior;
    }
    
    public void setLimite_superior(int limite_superior) {
        this.limite_superior = limite_superior;
    }
    
    public void setMonto(float monto) {
        this.monto = monto;
    }

}
