package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "rut")
public class RutEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rut;
}
