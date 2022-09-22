package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.AsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class AsistenciaServicio {
    @Autowired
    AsistenciaRepositorio asistenciaRepositorio;

    public ArrayList<AsistenciaEntidad> getAsistencias(){
        return (ArrayList<AsistenciaEntidad>) asistenciaRepositorio.findAll();
    }

    public AsistenciaEntidad saveAsistencia(AsistenciaEntidad asistencia){
        return asistenciaRepositorio.save(asistencia);
    }

    public Optional<AsistenciaEntidad> getById(Long id){
        Optional<AsistenciaEntidad> asistenciaEntidad = asistenciaRepositorio.findById(id);
        return asistenciaEntidad;
    }

    public boolean deleteAsistencia(Long id) {
        try{
            asistenciaRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
