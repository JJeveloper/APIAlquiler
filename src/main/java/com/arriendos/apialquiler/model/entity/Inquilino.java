package com.arriendos.apialquiler.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "inquilino")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idinquilino;

    private String nombre;

    private String telefono;

    private BigDecimal salario;

    @OneToOne(mappedBy = "inquilino")
    private Contrato contrato;

}
