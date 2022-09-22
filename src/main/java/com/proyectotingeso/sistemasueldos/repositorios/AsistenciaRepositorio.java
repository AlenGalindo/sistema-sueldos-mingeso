package com.proyectotingeso.sistemasueldos.repositorios;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AsistenciaRepositorio extends JpaRepository<AsistenciaEntidad,Long> {
}
