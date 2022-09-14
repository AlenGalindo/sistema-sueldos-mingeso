package com.proyectotingeso.sistemasueldos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "categoria_empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntidad {
    //Id unico del empleado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_categoria;

    //Nombre de la categoria
    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private int sueldo_fijo;


}