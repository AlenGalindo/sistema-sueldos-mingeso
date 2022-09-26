package com.proyectotingeso.sistemasueldos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "asistencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true,nullable = false)
    private int id;
    private Date fecha;
    private String rut;

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getRut() {
        return rut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
