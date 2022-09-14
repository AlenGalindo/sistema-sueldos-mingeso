package com.proyectotingeso.sistemasueldos.entidades;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntidad {
    //Id unico del empleado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_empleado;

    //Nombre del empleado
    @Column(nullable = false)
    private String nombre;

    //References the unique citizen identifier of the employee
    @Column(unique = true, nullable = false)
    private String rut;

    //References the role of the employee in the organization
    @Column(nullable = false)
    private String categoria;

    //References the antiquity characteristic of an employee
    @Column(nullable = false)
    private Date fecha_contratacion;
}
