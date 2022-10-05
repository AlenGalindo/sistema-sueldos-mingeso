package com.proyectotingeso.sistemasueldos.repositorios;

import com.proyectotingeso.sistemasueldos.entidades.PlanillaEntidad;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanillaRepositorio extends CrudRepository<PlanillaEntidad, Integer> {
    @Modifying
    @Query(value = "TRUNCATE db.planilla;", nativeQuery = true)
    void truncate();
}
