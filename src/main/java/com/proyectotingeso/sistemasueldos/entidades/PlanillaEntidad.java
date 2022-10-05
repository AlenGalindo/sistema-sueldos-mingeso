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
    private float annos_servicio;
    private float sueldo_fijo;
    private float sueldo_bruto;
    private float monto_bono;
    private float monto_extras;
    private float monto_descuentos;
    private float previsional;
    private float salud;
    private float liquido;

}
