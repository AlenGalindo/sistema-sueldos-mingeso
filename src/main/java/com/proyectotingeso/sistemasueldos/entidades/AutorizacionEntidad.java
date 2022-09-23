package com.proyectotingeso.sistemasueldos.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "autorizacion")
public class AutorizacionEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean aplica;

    @OneToOne
    @JoinColumn(name = "id_autorizacion")
    private AsistenciaEntidad asistencia;
}
