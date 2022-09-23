package com.proyectotingeso.sistemasueldos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "asistencia")
public class AsistenciaEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String rut;

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getRut() {
        return rut;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
