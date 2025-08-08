package com.arriendos.apialquiler.model.mapper;

import com.arriendos.apialquiler.model.dto.ContratoDTO;
import com.arriendos.apialquiler.model.entity.Contrato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContratoMapper {

    @Mapping(source = "departamentos.iddepartamentos", target = "iddepartamentos")
    @Mapping(source = "inquilino.idinquilino", target = "idinquilino")
    ContratoDTO contratoAContratoDTO(Contrato contrato);

    //@Mapping(target = "fechadeinicio", ignore = true)
    Contrato contratoDTOAContrato(ContratoDTO contratoDTO);

    List<ContratoDTO> contratoListAContratoDTOList(List<Contrato> contratoList);


}
