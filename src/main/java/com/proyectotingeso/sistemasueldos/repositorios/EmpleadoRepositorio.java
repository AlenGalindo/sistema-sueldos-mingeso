package com.proyectotingeso.sistemasueldos.repositorios;

import com.proyectotingeso.sistemasueldos.entidades.EmpleadoEntidad;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepositorio extends CrudRepository <EmpleadoEntidad, Long>{
}
