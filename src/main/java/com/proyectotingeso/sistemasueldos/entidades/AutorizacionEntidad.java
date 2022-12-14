package com.proyectotingeso.sistemasueldos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "autorizacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorizacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String fecha;
    private String rut;
}
