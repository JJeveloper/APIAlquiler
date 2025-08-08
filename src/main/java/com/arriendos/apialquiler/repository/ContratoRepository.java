package com.arriendos.apialquiler.repository;

import com.arriendos.apialquiler.model.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
}
