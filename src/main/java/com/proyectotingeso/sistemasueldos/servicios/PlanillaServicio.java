package com.proyectotingeso.sistemasueldos.servicios;

import com.proyectotingeso.sistemasueldos.controladores.CalculosControlador;
import com.proyectotingeso.sistemasueldos.controladores.ConvertidorControlador;
import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import com.proyectotingeso.sistemasueldos.entidades.AutorizacionEntidad;
import com.proyectotingeso.sistemasueldos.entidades.EmpleadoEntidad;
import com.proyectotingeso.sistemasueldos.entidades.JustificativoEntidad;
import com.proyectotingeso.sistemasueldos.entidades.PlanillaEntidad;
import com.proyectotingeso.sistemasueldos.repositorios.*;
import java.time.LocalDate;

import net.bytebuddy.asm.Advice.Local;

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
                    if(!justificativo.getFecha().equals(asistencia.getFecha()) && hora_llegada == 8){
                        float descuento = calculosControlador.getDescuentoAtraso(hora_llegada, minutos_llegada);
                        if(descuento < 0){
                            inasistencia ++;
                        }else{
                            nuevaPlanilla.setMonto_descuentos(nuevaPlanilla.getMonto_descuentos() + descuento*empleadoEntidad.getSueldo_fijo());
                        }
                    }
                }
                
            }

            float annos_servicio = LocalDate.now().getYear() - convertidor.getAnnoFecha(empleadoEntidad.getFecha_contratacion());
            nuevaPlanilla.setAnnos_servicio(annos_servicio);
            nuevaPlanilla.setMonto_bono(empleadoEntidad.getSueldo_fijo()*calculosControlador.getBonosAnnosServicio(empleadoEntidad.getFecha_contratacion()));
            float sueldo_bruto = empleadoEntidad.getSueldo_fijo() + nuevaPlanilla.getMonto_extras() + nuevaPlanilla.getMonto_bono() - nuevaPlanilla.getMonto_descuentos();
            nuevaPlanilla.setSueldo_bruto(sueldo_bruto);
            nuevaPlanilla.setPrevisional(sueldo_bruto*0.1f);
            nuevaPlanilla.setSalud(sueldo_bruto*0.08f);
            nuevaPlanilla.setLiquido(sueldo_bruto - nuevaPlanilla.getSalud() - nuevaPlanilla.getPrevisional());
            savePlanilla(nuevaPlanilla);
        }
    }
}
