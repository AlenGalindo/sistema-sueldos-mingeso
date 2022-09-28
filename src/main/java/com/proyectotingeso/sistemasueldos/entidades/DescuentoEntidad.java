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


}
