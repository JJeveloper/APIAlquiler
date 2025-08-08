package com.arriendos.apialquiler.service.impl;

import com.arriendos.apialquiler.model.dto.InquilinoDTO;
import com.arriendos.apialquiler.model.entity.Contrato;
import com.arriendos.apialquiler.model.entity.Inquilino;
import com.arriendos.apialquiler.model.exception.BadRequestException;
import com.arriendos.apialquiler.model.exception.RecursoNoEncontrado;
import com.arriendos.apialquiler.model.mapper.InquilinoMapper;
import com.arriendos.apialquiler.repository.ContratoRepository;
import com.arriendos.apialquiler.repository.DepartamentosRepository;
import com.arriendos.apialquiler.repository.InquilinoRepository;
import com.arriendos.apialquiler.service.interfaces.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class InquilinoServiceImpl implements InquilinoService {

    private InquilinoRepository inquilinoRepository;
    private ContratoRepository contratoRepository;
    private InquilinoMapper inquilinoMapper;


    @Autowired
    public InquilinoServiceImpl(InquilinoRepository inquilinoRepository, InquilinoMapper inquilinoMapper, ContratoRepository contratoRepository) {
        this.inquilinoRepository = inquilinoRepository;
        this.inquilinoMapper = inquilinoMapper;
        this.contratoRepository = contratoRepository;
    }

    @Override
    @Transactional // Transacción de escritura (commit o rollback)
    public InquilinoDTO guardarInquilino(InquilinoDTO inquilinoDTO) {

        Inquilino guardarInquilino = inquilinoMapper.inquilinoDTOAInquilino(inquilinoDTO);

        Inquilino inquilinoGuardado = inquilinoRepository.save(guardarInquilino);

        return inquilinoMapper.inquilinoAInquilinoDTO(inquilinoGuardado);

    }

    @Override
    @Transactional // Transacción de escritura (commit o rollback)
    public InquilinoDTO actualizarInquilino(Integer id, InquilinoDTO inquilinoDTO) {

        Optional<Inquilino> inquilinoOptional = inquilinoRepository.findById(id);


        if (inquilinoOptional.isPresent()) {

            Inquilino actualizarInquilino = inquilinoOptional.get();
            actualizarInquilino.setNombre(inquilinoDTO.getNombre());
            actualizarInquilino.setTelefono(inquilinoDTO.getTelefono());
            actualizarInquilino.setSalario(inquilinoDTO.getSalario());

            inquilinoRepository.save(actualizarInquilino);

            InquilinoDTO actualizado = inquilinoMapper.inquilinoAInquilinoDTO(actualizarInquilino);

            return actualizado;

        } else {
            throw new RecursoNoEncontrado("El inquilino no existe, no se puede actualizar");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public InquilinoDTO buscarInquilinoPorId(Integer id) {

        Optional<Inquilino> inquilino = inquilinoRepository.findById(id);

        if (inquilino.isEmpty()) {
            throw new RecursoNoEncontrado("no existe el inquilino");
        }

        return inquilinoMapper.inquilinoAInquilinoDTO(inquilino.get());

    }

    @Override
    @Transactional(readOnly = true)
    public List<InquilinoDTO> obtenerTodosLosInquilinos() {

        List<Inquilino> inquilinoList = inquilinoRepository.findAll();

        List<InquilinoDTO> inquilinoDTOList = inquilinoMapper.inquilinoListAInquilinoDTOList(inquilinoList);


        return inquilinoDTOList;
    }

    @Override
    @Transactional // Transacción de escritura (commit o rollback)
    public void eliminarInquilinoPorId(Integer id) {

        Inquilino inquilino = inquilinoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe el inquilino"));

        List<Contrato> contratoInquilinoId = contratoRepository.findAll();

        for (int i = 0; i < contratoInquilinoId.size(); i++) {

            int idInquilino = contratoInquilinoId.get(i).getInquilino().getIdinquilino();

            if (inquilino.getIdinquilino() == idInquilino) {
                throw new BadRequestException("El inquilino no se puede eliminar, posee un contrato");
            }
        }

        inquilinoRepository.deleteById(id);

    }
}
