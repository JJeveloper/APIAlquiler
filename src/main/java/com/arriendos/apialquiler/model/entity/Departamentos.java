package com.arriendos.apialquiler.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departamentos")
public class Departamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddepartamentos;

    private  String descripcion;

    private int precio;

    private String direccion;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_idpropietario" , referencedColumnName = "idpropietario")
    private Propietario propietario;

    @OneToOne(mappedBy = "departamentos")
    private Contrato contrato;

    public Departamentos() {
    }

    public Departamentos(String descripcion, int precio, String direccion, Estado estado, Propietario propietario, Contrato contrato) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.direccion = direccion;
        this.estado = estado;
        this.propietario = propietario;
        this.contrato = contrato;
    }

    public Integer getIddepartamentos() {
        return iddepartamentos;
    }

    public void setIddepartamentos(Integer iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
