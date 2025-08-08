package com.arriendos.apialquiler.service.interfaces;

import com.arriendos.apialquiler.model.dto.InquilinoDTO;

import java.util.List;

public interface InquilinoService {

    InquilinoDTO guardarInquilino(InquilinoDTO inquilinoDTO);

    InquilinoDTO actualizarInquilino(Integer id,InquilinoDTO inquilinoDTO);

    InquilinoDTO buscarInquilinoPorId(Integer id);

    List<InquilinoDTO> obtenerTodosLosInquilinos();

    void eliminarInquilinoPorId(Integer id);

}
