package com.arriendos.apialquiler.model.mapper;

import com.arriendos.apialquiler.model.dto.DepartamentoPropietarioDTO;
import com.arriendos.apialquiler.model.dto.PropietarioDTO;
import com.arriendos.apialquiler.model.entity.Departamentos;
import com.arriendos.apialquiler.model.entity.Propietario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartamentoPropietarioMapper {

    @Mapping(source = "propietario.idpropietario", target = "idpropietario")
    DepartamentoPropietarioDTO departamentoADepartamentoDTO(Departamentos departamentos);

    Departamentos departamentoDTOADeparamento(DepartamentoPropietarioDTO departamentoPropietarioDTO);

    List<DepartamentoPropietarioDTO> departamentoListADepartamentoPropietarioDTOList(List<Departamentos> Departamentos);

   // PropietarioDTO propietarioAPropietarioDTO(Propietario propietario);

}
