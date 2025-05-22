package com.arriendos.apialquiler.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "departamentos")
public class Departamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddepartamentos;

    private  String descripcion;

    private BigDecimal precio;

    private String direccion;

    private String estado;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpropietario")
    private Propietario propietario;

    @OneToOne(mappedBy = "departamentos")
    private Contrato contrato;

    

}
