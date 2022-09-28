package com.proyectotingeso.sistemasueldos.repositorios;

import com.proyectotingeso.sistemasueldos.entidades.CategoriaHoraExtraEntidad;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepositorio extends CrudRepository<CategoriaHoraExtraEntidad, Integer> {
}
