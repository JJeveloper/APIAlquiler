package com.arriendos.apialquiler.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class InquilinoDTO {

    private Integer idinquilino;

    @NotBlank(message = "no campos vacios")
    private String nombre;

    @NotBlank(message = "no campos vacios")
    private String telefono;

    @NotNull(message = "no campos vacios")
    @DecimalMin(value = "150.00" , message = "no puede ser menor 150.00")
    @DecimalMax(value = "1000.00" , message = "no puede ser mayor 1000.00")
    private BigDecimal salario;

    public InquilinoDTO() {
    }

    public InquilinoDTO(String nombre, String telefono, BigDecimal salario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.salario = salario;
    }

    public Integer getIdinquilino() {
        return idinquilino;
    }

    public void setIdinquilino(Integer idinquilino) {
        this.idinquilino = idinquilino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}

