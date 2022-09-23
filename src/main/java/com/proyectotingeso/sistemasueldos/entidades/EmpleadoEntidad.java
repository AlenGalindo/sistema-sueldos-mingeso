package com.proyectotingeso.sistemasueldos.entidades;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "empleado")
public class EmpleadoEntidad {
    //Id unico del empleado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date contratacion;
}
