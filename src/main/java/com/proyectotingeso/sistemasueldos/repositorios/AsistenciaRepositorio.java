package com.proyectotingeso.sistemasueldos.repositorios;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepositorio extends CrudRepository<AsistenciaEntidad,Integer> {
}
