package com.arriendos.apialquiler.repository;

import com.arriendos.apialquiler.model.entity.Departamentos;
import com.arriendos.apialquiler.model.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentosRepository extends JpaRepository<Departamentos, Integer> {

    @Query("SELECT d FROM Departamentos d WHERE d.estado = :e")
    public abstract List<Departamentos> findDepartamentoPorEstado(@Param("e") Estado e);

}
