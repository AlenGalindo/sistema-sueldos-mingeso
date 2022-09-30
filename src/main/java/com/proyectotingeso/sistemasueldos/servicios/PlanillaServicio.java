package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.entidades.PlanillaEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.AsistenciaRepositorio;
import com.proyectotingeso.sistemasueldos.repositorios.PlanillaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlanillaServicio {

    @Autowired
    PlanillaRepositorio planillaRepositorio;

    public ArrayList<PlanillaEntidad> getPlanillas(){
        return (ArrayList<PlanillaEntidad>) planillaRepositorio.findAll();
    }

    public PlanillaEntidad savePlanilla(PlanillaEntidad planilla){
        return planillaRepositorio.save(planilla);
    }

    public Optional<PlanillaEntidad> getById(int id){
        Optional<PlanillaEntidad> PlanillaEntidad = planillaRepositorio.findById(id);
        return PlanillaEntidad;
    }

    public boolean deletePlanilla(int id) {
        try{
            planillaRepositorio.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
