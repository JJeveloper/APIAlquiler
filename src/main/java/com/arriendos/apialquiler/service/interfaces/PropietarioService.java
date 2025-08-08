package com.arriendos.apialquiler.service.interfaces;

import com.arriendos.apialquiler.model.dto.PropietarioDTO;

import java.util.List;

public interface PropietarioService {

    PropietarioDTO guardarPropietario(PropietarioDTO propietario);

    PropietarioDTO actualizarPropietario(Integer id, PropietarioDTO propietarioDTO);

    PropietarioDTO buscarPropietarioPorId(Integer id);

    List<PropietarioDTO> obtenerTodosLosPropietarios();

    void eliminarPropietarioPorID(Integer id);


}
