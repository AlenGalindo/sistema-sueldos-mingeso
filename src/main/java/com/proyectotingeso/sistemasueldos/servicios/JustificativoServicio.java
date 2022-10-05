package com.proyectotingeso.sistemasueldos.servicios;

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

    public Optional<JustificativoEntidad> getById(int id){
        Optional<JustificativoEntidad> justificativo = justificativoRepositorio.findById(id);
        return justificativo;
    }

    public boolean deleteJustificativo(int id) {
        try{
            justificativoRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean getByFecha(String fecha_asistencia) {
        for(JustificativoEntidad justificativo:  (ArrayList<JustificativoEntidad>) justificativoRepositorio.findAll()){
            String justi_fecha = justificativo.getFecha();
            if(fecha_asistencia.equals(justi_fecha)){
                return true;
            }
        }
        return false;
    }
}
