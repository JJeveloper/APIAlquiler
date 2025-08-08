package com.arriendos.apialquiler.repository;

import com.arriendos.apialquiler.model.entity.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Integer> {
}
