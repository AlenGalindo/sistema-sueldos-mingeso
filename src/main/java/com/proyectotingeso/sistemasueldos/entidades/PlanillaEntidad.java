package com.proyectotingeso.sistemasueldos.entidades;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "planilla")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanillaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true,nullable = false)
    private int id;
    private String nombre;
    private String rut;
    private String categoria;
    private int annos_servicio;
    private int sueldo_fijo;
    private int monto_bono;
    private int monto_extras;
    private int monto_descuentos;
    private float previsional;
    private float salud;
    private float liquido;

}
