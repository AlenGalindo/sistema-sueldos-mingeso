package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.controladores.AutorizacionControlador;
import com.proyectotingeso.sistemasueldos.entidades.AutorizacionEntidad;
import com.proyectotingeso.sistemasueldos.entidades.JustificativoEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.AutorizacionRepositorio;
import com.proyectotingeso.sistemasueldos.repositorios.JustificativoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AutorizacionServicio {
    @Autowired
    AutorizacionRepositorio autorizacionRepositorio;

    public ArrayList<AutorizacionEntidad> getAutorizaciones(){
        return (ArrayList<AutorizacionEntidad>) autorizacionRepositorio.findAll();
    }

    public AutorizacionEntidad saveAutorizacion (AutorizacionEntidad autorizacion){
        return autorizacionRepositorio.save(autorizacion);
    }

    public Optional<AutorizacionEntidad> getById(int id){
        Optional<AutorizacionEntidad> autorizacion = autorizacionRepositorio.findById(id);
        return autorizacion;
    }

    public boolean deleteAutorizacion(int id) {
        try{
            autorizacionRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
