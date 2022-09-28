package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;

@Entity
@Table(name = "categoria_sueldo")
public class CategoriaSueldoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoria;
    private int sueldo;
}
