package com.arriendos.apialquiler.model.entity;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcontrato;

    private int duracion;

    private Date fechadeinicio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcontrato")
    private Inquilino inquilino;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcontrato")
    private Departamentos departamentos;
}
