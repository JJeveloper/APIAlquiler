package com.arriendos.apialquiler.model.dto;

import com.arriendos.apialquiler.model.entity.Estado;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DepartamentoPropietarioDTO {

    private  Integer iddepartamentos;

    @NotBlank(message = "no campos vacios")
    private String descripcion;

    @Positive(message = "valor invalido")
    @NotNull(message = "no campos vacios")
    private int precio;

    @NotBlank(message = "no campos vacios")
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @NotNull(message = "no campos vacios")
    @Positive(message = "valor invalido")
    private int idpropietario;

    public DepartamentoPropietarioDTO() {
    }

    public DepartamentoPropietarioDTO(String descripcion, int precio, String direccion, Estado estado, int idpropietario) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.direccion = direccion;
        this.estado = estado;
        this.idpropietario = idpropietario;
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

    public int getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(int idpropietario) {
        this.idpropietario = idpropietario;
    }
}
