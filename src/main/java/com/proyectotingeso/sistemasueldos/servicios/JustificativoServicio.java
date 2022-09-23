package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.entidades.JustificativoEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.JustificativoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JustificativoServicio {
    @Autowired
    JustificativoRepositorio justificativoRepositorio;

    public ArrayList<JustificativoEntidad> getJustificativos(){
        return (ArrayList<JustificativoEntidad>) justificativoRepositorio.findAll();
    }

    public JustificativoEntidad saveJustificativo (JustificativoEntidad justificativo){
        return justificativoRepositorio.save(justificativo);
    }

    public Optional<JustificativoEntidad> getById(Long id){
        Optional<JustificativoEntidad> justificativo = justificativoRepositorio.findById(id);
        return justificativo;
    }

    public boolean deleteJustificativo(Long id) {
        try{
            justificativoRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
