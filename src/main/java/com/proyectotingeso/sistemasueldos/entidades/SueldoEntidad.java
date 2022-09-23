package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sueldo")
public class SueldoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntidad categoria;
}
