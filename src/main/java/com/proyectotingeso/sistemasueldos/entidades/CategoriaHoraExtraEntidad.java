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


}