package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "sobretiempo")
public class SobretiempoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int categoria;
    private int monto;
}
