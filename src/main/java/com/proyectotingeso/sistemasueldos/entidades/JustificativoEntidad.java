package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "justificativo")
public class JustificativoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aplica;

    @ManyToOne
    @JoinColumn(name = "id_asistencia")
    private AsistenciaEntidad asistencia;
}
