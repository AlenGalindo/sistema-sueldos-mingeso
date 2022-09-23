package com.proyectotingeso.sistemasueldos.repositorios;

import com.proyectotingeso.sistemasueldos.entidades.AsistenciaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepositorio extends JpaRepository<AsistenciaEntidad,Long> {
}
