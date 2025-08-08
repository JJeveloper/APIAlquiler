package com.arriendos.apialquiler.service.interfaces;

import com.arriendos.apialquiler.model.dto.DepartamentoPropietarioDTO;

import java.util.List;

public interface DepartamentosService {

    DepartamentoPropietarioDTO guardarDepartamento(DepartamentoPropietarioDTO departamentoDTO);

    DepartamentoPropietarioDTO actualizarDepartamento(Integer id, DepartamentoPropietarioDTO departamentoDTO);

    DepartamentoPropietarioDTO buscarDepartamentoPorId(Integer id);

    List<DepartamentoPropietarioDTO> obtenerDepartamentoPorEstado(String estado);

    List<DepartamentoPropietarioDTO> obtenerTodosLosDepartamentos();

    void eliminarDepartamento(Integer id);
}
