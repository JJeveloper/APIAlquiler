package com.arriendos.apialquiler.repository;

import com.arriendos.apialquiler.model.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario,Integer> {
}
