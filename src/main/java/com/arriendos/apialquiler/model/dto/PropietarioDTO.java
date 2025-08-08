package com.arriendos.apialquiler.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PropietarioDTO {

    private Integer idpropietario;

    @NotBlank(message = "no campos vacios")
    private String nombres;

    /*
     * Validacion Telefono
     * Los numeros de celular inician con 09
     * expresion regular que permite numeros de 0 hasta el 9
     * longitud de 10 numeros que corresponden a un numero de celular
     */
    @Pattern(regexp = "^(09)\\d{8}" , message = "numero de telefono incorrecto")
    private String telefono;

    public PropietarioDTO() {
    }

    public PropietarioDTO(String nombres, String telefono) {
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
}
