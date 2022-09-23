package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "bono")
public class BonoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int  limite_inferior;
    private int limite_superior;
    private float porcentaje;
}
