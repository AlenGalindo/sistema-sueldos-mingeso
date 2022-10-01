package com.proyectotingeso.sistemasueldos.entidades;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "empleado")
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntidad {
    //Id unico del empleado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String fecha_contratacion;
    private String rut;

    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public String getRut() {
        return rut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
