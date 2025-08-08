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
    @JoinColumn(name = "inquilino_idinquilino" , referencedColumnName = "idinquilino")
    private Inquilino inquilino;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departamentos_iddepartamentos" , referencedColumnName = "iddepartamentos")
    private Departamentos departamentos;

    public Contrato() {
    }

    public Contrato(int duracion, Date fechadeinicio, Inquilino inquilino, Departamentos departamentos) {
        this.duracion = duracion;
        this.fechadeinicio = fechadeinicio;
        this.inquilino = inquilino;
        this.departamentos = departamentos;
    }

    public Integer getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(Integer idcontrato) {
        this.idcontrato = idcontrato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFechadeinicio() {
        return fechadeinicio;
    }

    public void setFechadeinicio(Date fechadeinicio) {
        this.fechadeinicio = fechadeinicio;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }
}
