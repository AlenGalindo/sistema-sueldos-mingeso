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

    private int sueldo_fijo;

    private String categoria;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getSueldo_fijo() {
        return sueldo_fijo;
    }

    public void setSueldo_fijo(int sueldo_fijo) {
        this.sueldo_fijo = sueldo_fijo;
    }
}
