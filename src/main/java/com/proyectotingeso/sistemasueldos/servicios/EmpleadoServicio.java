package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.entidades.EmpleadoEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpleadoServicio {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    public ArrayList<EmpleadoEntidad> getEmpleados(){
        return (ArrayList<EmpleadoEntidad>) empleadoRepositorio.findAll();
    }

    public EmpleadoEntidad saveEmpleado(EmpleadoEntidad empleado){
        return empleadoRepositorio.save(empleado);
    }

    public Optional<EmpleadoEntidad> getPorId(Long id){
        return empleadoRepositorio.findById(id);
    }

    public boolean deleteEmpleado(Long id) {
        try{
            empleadoRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
