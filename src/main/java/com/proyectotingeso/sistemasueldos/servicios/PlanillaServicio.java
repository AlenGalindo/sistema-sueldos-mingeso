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
            String fecha_contratacion = empleadoEntidad.getFecha_contratacion();
            nuevaPlanilla.setMonto_bono((int) (calculosControlador.getBonosAnnosServicio(fecha_contratacion)));
            nuevaPlanilla.setNombre(empleadoEntidad.getNombre());
            nuevaPlanilla.setRut(empleadoEntidad.getRut());
            nuevaPlanilla.setCategoria(empleadoEntidad.getCategoria());
            nuevaPlanilla.setSueldo_fijo(empleadoEntidad.getSueldo_fijo());

            //Calculo de horas extra y descuentos por atraso
            for (AsistenciaEntidad asistencia : (ArrayList<AsistenciaEntidad>) asistenciaServicio.getAsistencias()) {
                for (AutorizacionEntidad autorizacion : (ArrayList<AutorizacionEntidad>) autorizacionServicio.getAutorizaciones()) {
                    String rut_empleado = empleadoEntidad.getRut();
                    String rut_asistencia = asistencia.getRut();
                    String fecha_asistencia = asistencia.getFecha();
                    String fecha_autorizacion = autorizacion.getFecha();
                    String rut_autorizacion = autorizacion.getRut();
                    int sueldo_bruto = empleadoEntidad.getSueldo_fijo();
                    int hora_llegada = convertidor.getHora(asistencia.getHora());
                    int hora_minutos_llegada = convertidor.getMinutos(asistencia.getHora());
                    int hora_salida = convertidor.getHora(asistencia.getHora());
                    int monto_hora_extra = 0;
                    int inasistencia = 0;
                    float descuento = 0;

                    if (rut_empleado == rut_autorizacion && rut_empleado == rut_asistencia && fecha_asistencia == fecha_autorizacion && hora_salida > 18) {
                        monto_hora_extra = calculosControlador.montoHorasExtra(hora_salida, empleadoEntidad.getCategoria());
                        nuevaPlanilla.setMonto_extras(nuevaPlanilla.getMonto_extras() + monto_hora_extra);
                    }

                    if (hora_llegada == 8 && hora_minutos_llegada > 0) {
                        if (justificativoServicio.getByFecha(fecha_asistencia) == false) {
                            int hora = convertidor.getHora(asistencia.getHora());
                            int minutos = convertidor.getMinutos(asistencia.getHora());
                            float des;
                            if ((des = calculosControlador.getDescuentoAtraso(hora, minutos)) < 0) {
                                inasistencia = inasistencia + 1;
                            } else {
                                descuento = descuento + des;
                            }
                        }
                    }
                }
            }

            float sueldo = calculosControlador.sueldoNoCot(nuevaPlanilla.getMonto_extras(), nuevaPlanilla.getMonto_bono(), nuevaPlanilla.getMonto_descuentos());

            float previsional = sueldo * 0.1f;
            float salud = sueldo * 0.08f;

            nuevaPlanilla.setPrevisional(previsional);
            nuevaPlanilla.setSalud(salud);

            float liquido = sueldo - (salud + previsional);
            nuevaPlanilla.setLiquido(liquido);

            System.out.println(nuevaPlanilla.getNombre());
            planillaRepositorio.save(nuevaPlanilla);
        }
    }
}
