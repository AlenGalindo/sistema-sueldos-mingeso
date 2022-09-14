package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.entidades.CategoriaEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    public ArrayList<CategoriaEntidad> getCategorias(){
        return (ArrayList<CategoriaEntidad>) categoriaRepositorio.findAll();
    }

    public CategoriaEntidad saveCategoria(CategoriaEntidad empleado){
        return categoriaRepositorio.save(empleado);
    }

    public Optional<CategoriaEntidad> getPorId(Long id){
        return categoriaRepositorio.findById(id);
    }

    public boolean deleteCategoria(Long id) {
        try{
            categoriaRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}