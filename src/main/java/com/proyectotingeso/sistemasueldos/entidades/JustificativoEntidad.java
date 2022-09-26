package com.proyectotingeso.sistemasueldos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "justificativo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JustificativoEntidad{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true,nullable = false)
    private int id;
    private String aplica;
    private int id_asistencia;
}
