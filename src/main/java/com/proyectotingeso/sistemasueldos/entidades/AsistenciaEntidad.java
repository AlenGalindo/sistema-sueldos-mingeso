package com.proyectotingeso.sistemasueldos.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "libro_asistencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_asistencia;



    @Column(nullable = false)
    private Long id_empleado;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String hora_entrada;

    @Column(nullable = false)
    private String hora_salida;

    @Column(nullable = false)
    private int justificativo;

    @Column(nullable = false)
    private int horas_extra;

    public AsistenciaEntidad(int justificativo, int horas_extra) {
        this.justificativo = justificativo;
        this.horas_extra = horas_extra;
    }

    public Long getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(Long id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getJustificativo() {
        return justificativo;
    }

    public void setJustificativo(int justificativo) {
        this.justificativo = justificativo;
    }

    public int getHoras_extra() {
        return horas_extra;
    }

    public void setHoras_extra(int horas_extra) {
        this.horas_extra = horas_extra;
    }
}
