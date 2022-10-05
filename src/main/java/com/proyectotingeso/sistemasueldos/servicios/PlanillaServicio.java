package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.controladores.CalculosControlador;
import com.proyectotingeso.sistemasueldos.controladores.ConvertidorControlador;
import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.entidades.AutorizacionEntidad;
import com.proyectotingeso.sistemasueldos.entidades.EmpleadoEntidad;
import com.proyectotingeso.sistemasueldos.entidades.JustificativoEntidad;
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
            float inasistencia = 0;

            for(AsistenciaEntidad asistencia: (ArrayList<AsistenciaEntidad>) asistenciaServicio.getAsistencias()){
                for(AutorizacionEntidad autorizacion: (ArrayList<AutorizacionEntidad>) autorizacionServicio.getAutorizaciones()){
                    int hora_salida = convertidor.getHora(asistencia.getHora());
                    if(hora_salida >18 && asistencia.getFecha().equals(autorizacion.getFecha())){
                        float monto = (float) calculosControlador.montoHorasExtra(hora_salida, empleadoEntidad.getCategoria());
                        nuevaPlanilla.setMonto_extras(nuevaPlanilla.getMonto_extras() + monto);
                    }

                }

                for(JustificativoEntidad justificativo: (ArrayList<JustificativoEntidad>) justificativoServicio.getJustificativos()){
                    int hora_llegada = convertidor.getHora(asistencia.getHora());
                    int minutos_llegada = convertidor.getMinutos(asistencia.getHora());
                    if(justificativoServicio.getByFecha(asistencia.getFecha()) == false && hora_llegada == 8){
                        float descuento = calculosControlador.getDescuentoAtraso(hora_llegada, minutos_llegada);
                        if(descuento < 0){
                            inasistencia ++;
                        }else{
                            nuevaPlanilla.setMonto_descuentos(nuevaPlanilla.getMonto_descuentos() + descuento*empleadoEntidad.getSueldo_fijo());
                        }
                    }
                }
            }

            savePlanilla(nuevaPlanilla);
        }
    }
}
