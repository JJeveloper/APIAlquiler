package com.arriendos.apialquiler.service.interfaces;

import com.arriendos.apialquiler.model.dto.ContratoDTO;

import java.util.List;

public interface ContratoService {

    ContratoDTO guardarContrato(ContratoDTO contratoDTO);

    ContratoDTO buscarContratoPorId(Integer id);

    List<ContratoDTO> obtenerTodosLosContratos();

    void eliminarContrato(Integer id);

}
