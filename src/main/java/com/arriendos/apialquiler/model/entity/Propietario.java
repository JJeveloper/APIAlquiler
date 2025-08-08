package com.arriendos.apialquiler.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpropietario;

    private String nombres;

    private String telefono;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Departamentos> departamentos = new ArrayList<>();

    public Propietario() {
    }

    public Propietario(String nombres, String telefono, List<Departamentos> departamentos) {
        this.nombres = nombres;
        this.telefono = telefono;
        this.departamentos = departamentos;
    }

    public Propietario(String nombres, String telefono) {
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public Integer getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(Integer idpropietario) {
        this.idpropietario = idpropietario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Departamentos> getDepartamentos() {
        return departamentos;
    }

    public void agregarDepartamentos(Departamentos departamentos) {
        this.departamentos.add(departamentos);
        departamentos.setPropietario(this);
    }

    public void eliminarDepartamentos(Departamentos departamentos){
        this.departamentos.remove(departamentos);
        departamentos.setPropietario(null);
    }

}
