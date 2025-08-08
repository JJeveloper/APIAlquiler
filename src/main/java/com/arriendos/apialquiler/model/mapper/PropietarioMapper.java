package com.arriendos.apialquiler.model.mapper;

import com.arriendos.apialquiler.model.dto.PropietarioDTO;
import com.arriendos.apialquiler.model.entity.Propietario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropietarioMapper {

    PropietarioDTO propietarioAPropietarioDTO(Propietario propietario);

    Propietario propietarioDTOAPropietario(PropietarioDTO propietarioDTO);

    List<PropietarioDTO> propietarioListAPropietarioDTOList(List<Propietario> propietario);

}
