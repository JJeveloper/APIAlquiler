package com.arriendos.apialquiler.model.mapper;

import com.arriendos.apialquiler.model.dto.InquilinoDTO;
import com.arriendos.apialquiler.model.entity.Inquilino;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InquilinoMapper {

    InquilinoDTO inquilinoAInquilinoDTO(Inquilino inquilino);

    Inquilino inquilinoDTOAInquilino(InquilinoDTO inquilinoDTO);

    List<InquilinoDTO> inquilinoListAInquilinoDTOList(List<Inquilino> inquilinos);

}
