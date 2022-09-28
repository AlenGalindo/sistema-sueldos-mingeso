package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.entidades.CategoriaHoraExtraEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    public ArrayList<CategoriaHoraExtraEntidad> getCategorias(){
        return (ArrayList<CategoriaHoraExtraEntidad>) categoriaRepositorio.findAll();
    }

    public CategoriaHoraExtraEntidad saveCategoria(CategoriaHoraExtraEntidad empleado){
        return categoriaRepositorio.save(empleado);
    }

    public Optional<CategoriaHoraExtraEntidad> getPorId(int id){
        return categoriaRepositorio.findById(id);
    }

    public boolean deleteCategoria(int id) {
        try{
            categoriaRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}