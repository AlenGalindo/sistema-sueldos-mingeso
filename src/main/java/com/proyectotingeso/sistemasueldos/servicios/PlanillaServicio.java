package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.controladores.CalculosControlador;
import com.proyectotingeso.sistemasueldos.controladores.ConvertidorControlador;
import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.entidades.AutorizacionEntidad;
import com.proyectotingeso.sistemasueldos.entidades.EmpleadoEntidad;
import com.proyectotingeso.sistemasueldos.entidades.PlanillaEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlanillaServicio {

    @Autowired
    PlanillaRepositorio planillaRepositorio;

    @Autowired
    EmpleadoServicio empleadoServicio;

    @Autowired
    JustificativoServicio justificativoServicio;

    @Autowired
    AutorizacionServicio autorizacionServicio;

    @Autowired
    CalculosControlador calculosControlador;
    @Autowired
    AsistenciaServicio asistenciaServicio;

    @Autowired
    ConvertidorControlador convertidor;

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

    public void crearPlanillas() {
        for (EmpleadoEntidad empleadoEntidad : (ArrayList<EmpleadoEntidad>) empleadoServicio.getEmpleados()) {
            System.out.println(empleadoEntidad.getNombre());
            System.out.println(empleadoEntidad.getFecha_contratacion());
            System.out.println(empleadoEntidad.getCategoria());
            System.out.println(empleadoEntidad.getRut());

            PlanillaEntidad nuevaPlanilla = new PlanillaEntidad();
            nuevaPlanilla.setNombre(empleadoEntidad.getNombre());
            nuevaPlanilla.setRut(empleadoEntidad.getRut());
            nuevaPlanilla.setSalud(0);
            nuevaPlanilla.setMonto_bono(0);
            nuevaPlanilla.setLiquido(0);
            nuevaPlanilla.setPrevisional(0);
            nuevaPlanilla.setCategoria(empleadoEntidad.getCategoria());
            nuevaPlanilla.setSueldo_fijo(empleadoEntidad.getSueldo_fijo());
            nuevaPlanilla.setAnnos_servicio(10);
            nuevaPlanilla.setMonto_descuentos(0);

            for(AsistenciaEntidad asistencia: (ArrayList<AsistenciaEntidad>) asistenciaServicio.getAsistencias()){
                for(AutorizacionEntidad autorizacion: (ArrayList<AutorizacionEntidad>) autorizacionServicio.getAutorizaciones()){
                    int hora_salida = convertidor.getHora(asistencia.getHora());
                    if(hora_salida >18 && autorizacion.getFecha().equals(autorizacion.getFecha())){
                        float monto = 18 - hora_salida;
                        nuevaPlanilla.setMonto_extras(nuevaPlanilla.getMonto_extras() + monto);
                    }

                }
            }

            savePlanilla(nuevaPlanilla);
        }
    }
}
