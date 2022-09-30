package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "bono")
public class BonoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int  limite_inferior;
    private int limite_superior;
    private float porcentaje;
}
