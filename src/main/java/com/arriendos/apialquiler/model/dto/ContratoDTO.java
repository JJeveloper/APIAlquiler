package com.arriendos.apialquiler.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class ContratoDTO {

    private Integer idcontrato;

    @Positive(message = "La duracion es en meses, intente nuevamente")
    @NotNull(message = "no campos vacios")
    private Integer duracion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechadeinicio;

    @Positive(message = "valor invalido")
    @NotNull(message = "no campos vacios")
    private Integer iddepartamentos;

    @Positive(message = "valor invalido")
    @NotNull(message = "no campos vacios")
    private Integer idinquilino;

    public ContratoDTO() {
    }

    public ContratoDTO(Integer idcontrato, Integer duracion, Date fechadeinicio, Integer iddepartamentos, Integer idinquilino) {
        this.idcontrato = idcontrato;
        this.duracion = duracion;
        this.fechadeinicio = fechadeinicio;
        this.iddepartamentos = iddepartamentos;
        this.idinquilino = idinquilino;
    }

    public Integer getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(Integer idcontrato) {
        this.idcontrato = idcontrato;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Date getFechadeinicio() {
        return fechadeinicio;
    }

    public void setFechadeinicio(Date fechadeinicio) {
        this.fechadeinicio = fechadeinicio;
    }

    public Integer getIddepartamentos() {
        return iddepartamentos;
    }

    public void setIddepartamentos(Integer iddepartamentos) {
        this.iddepartamentos = iddepartamentos;
    }

    public Integer getIdinquilino() {
        return idinquilino;
    }

    public void setIdinquilino(Integer idinquilino) {
        this.idinquilino = idinquilino;
    }
}
