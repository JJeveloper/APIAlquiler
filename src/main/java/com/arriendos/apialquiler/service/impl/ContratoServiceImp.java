package com.arriendos.apialquiler.service.impl;

import com.arriendos.apialquiler.model.dto.ContratoDTO;
import com.arriendos.apialquiler.model.entity.Contrato;
import com.arriendos.apialquiler.model.entity.Departamentos;
import com.arriendos.apialquiler.model.entity.Estado;
import com.arriendos.apialquiler.model.entity.Inquilino;
import com.arriendos.apialquiler.model.exception.BadRequestException;
import com.arriendos.apialquiler.model.exception.DatabaseException;
import com.arriendos.apialquiler.model.exception.RecursoNoEncontrado;
import com.arriendos.apialquiler.model.mapper.ContratoMapper;
import com.arriendos.apialquiler.repository.ContratoRepository;
import com.arriendos.apialquiler.repository.DepartamentosRepository;
import com.arriendos.apialquiler.repository.InquilinoRepository;
import com.arriendos.apialquiler.service.interfaces.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ContratoServiceImp implements ContratoService {

    private ContratoRepository contratoRepository;
    private InquilinoRepository inquilinoRepository;
    private DepartamentosRepository departamentosRepository;
    private ContratoMapper contratoMapper;

    @Autowired
    public ContratoServiceImp(ContratoRepository contratoRepository, InquilinoRepository inquilinoRepository, DepartamentosRepository departamentosRepository, ContratoMapper contratoMapper) {
        this.contratoRepository = contratoRepository;
        this.inquilinoRepository = inquilinoRepository;
        this.departamentosRepository = departamentosRepository;
        this.contratoMapper = contratoMapper;
    }


    @Override
    @Transactional
    public ContratoDTO guardarContrato(ContratoDTO contratoDTO) {

        Inquilino inquilinoId = inquilinoRepository.findById(contratoDTO.getIdinquilino())
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("No existe el inquilino");
                });

        Departamentos departamentosId = departamentosRepository.findById(contratoDTO.getIddepartamentos())
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("No existe el departamento");
                });

        //validar que no se repitan las claves foraneas
        List<Contrato> contratoList = contratoRepository.findAll();
        for (int i = 0; i < contratoList.size(); i++) {
            int idIdinquilino = contratoList.get(i).getInquilino().getIdinquilino();
            int idDepartamento = contratoList.get(i).getDepartamentos().getIddepartamentos();

            if (idIdinquilino == inquilinoId.getIdinquilino()) {
                throw new BadRequestException("El inquilino ya estan en uso");
            }
            if (idDepartamento == departamentosId.getIddepartamentos()) {
                throw new BadRequestException("El departamento ya estan en uso");
            }
        }


        //Obtener fecha actual
        java.util.Date fechaUtil = new java.util.Date();
        Date fechaSQL = new Date(fechaUtil.getTime());


        Contrato guardarContrato = contratoMapper.contratoDTOAContrato(contratoDTO);

        guardarContrato.setInquilino(inquilinoId);
        guardarContrato.setFechadeinicio(fechaSQL);
        guardarContrato.setDepartamentos(departamentosId);

        Contrato contratoGuardado = contratoRepository.save(guardarContrato);

        try {

            departamentosId.setEstado(Estado.inactivo);
            Departamentos actualizarEstado = departamentosRepository.save(departamentosId);
        } catch (Exception e) {
            throw new BadRequestException("No se puede guardar el contrato " + e.getMessage());
        }


        return contratoMapper.contratoAContratoDTO(contratoGuardado);

    }

    @Override
    @Transactional(readOnly = true)
    public ContratoDTO buscarContratoPorId(Integer id) {
        Contrato contratoPorId = contratoRepository.findById(id)
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("El contrato no existe");
                });
        ContratoDTO contratoDTO = contratoMapper.contratoAContratoDTO(contratoPorId);
        return contratoDTO;

    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratoDTO> obtenerTodosLosContratos() {
        try {
            List<Contrato> contratoList = contratoRepository.findAll();

            List<ContratoDTO> contratoDTOList = contratoMapper.contratoListAContratoDTOList(contratoList);

            return contratoDTOList;
        } catch (Exception e) {
            throw new BadRequestException(e + " {error} ");
        }
    }

    @Override
    @Transactional
    public void eliminarContrato(Integer id) {
        Contrato contratoPorId = contratoRepository.findById(id)
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("El contrato no existe");
                });

        try {
            contratoRepository.delete(contratoPorId);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }


    }
}
