package com.arriendos.apialquiler.service.impl;

import com.arriendos.apialquiler.model.dto.DepartamentoPropietarioDTO;
import com.arriendos.apialquiler.model.entity.Departamentos;
import com.arriendos.apialquiler.model.entity.Estado;
import com.arriendos.apialquiler.model.entity.Propietario;
import com.arriendos.apialquiler.model.exception.DatabaseException;
import com.arriendos.apialquiler.model.exception.RecursoNoEncontrado;
import com.arriendos.apialquiler.model.mapper.DepartamentoPropietarioMapper;
import com.arriendos.apialquiler.repository.DepartamentosRepository;
import com.arriendos.apialquiler.repository.PropietarioRepository;
import com.arriendos.apialquiler.service.interfaces.DepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentosService {

    private DepartamentosRepository departamentosRepository;
    private PropietarioRepository propietarioRepository;
    private DepartamentoPropietarioMapper departamentoPropietarioMapper;

    @Autowired
    public DepartamentoServiceImpl(DepartamentosRepository departamentosRepository, PropietarioRepository propietarioRepository, DepartamentoPropietarioMapper departamentoPropietarioMapper) {
        this.departamentosRepository = departamentosRepository;
        this.propietarioRepository = propietarioRepository;
        this.departamentoPropietarioMapper = departamentoPropietarioMapper;
    }

    @Override
    public DepartamentoPropietarioDTO guardarDepartamento(DepartamentoPropietarioDTO departamentoDTO) {

        Propietario idpropietario = propietarioRepository.findById(departamentoDTO.getIdpropietario())
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("No se puede agregar el departamento, no existe el propietario");
                });

        Departamentos crearDepartamentos = departamentoPropietarioMapper.departamentoDTOADeparamento(departamentoDTO);

        crearDepartamentos.setEstado(Estado.activo);
        crearDepartamentos.setPropietario(idpropietario);

        Departamentos nuevoDepartamento = departamentosRepository.save(crearDepartamentos);

        return departamentoPropietarioMapper.departamentoADepartamentoDTO(nuevoDepartamento);

    }

    @Override
    public DepartamentoPropietarioDTO actualizarDepartamento(Integer id, DepartamentoPropietarioDTO departamentoDTO) {

        Departamentos departamentoId = departamentosRepository.findById(id)
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("No existe el departamento");
                });

        Propietario idpropietario = propietarioRepository.findById(departamentoDTO.getIdpropietario())
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("No se puede actualizar el departamento, no existe el propietario");
                });

        Departamentos departamentoActualizado = departamentoPropietarioMapper.departamentoDTOADeparamento(departamentoDTO);

        departamentoActualizado.setEstado(Estado.activo);
        departamentoActualizado.setIddepartamentos(departamentoId.getIddepartamentos());
        departamentoActualizado.setPropietario(idpropietario);

        return departamentoPropietarioMapper.departamentoADepartamentoDTO(departamentosRepository.save(departamentoActualizado));
    }

    @Override
    public DepartamentoPropietarioDTO buscarDepartamentoPorId(Integer id) {

        Departamentos departamentoId = departamentosRepository.findById(id)
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("No existe el departamento");
                });

        DepartamentoPropietarioDTO departamentoPropietarioDTO = departamentoPropietarioMapper.departamentoADepartamentoDTO(departamentoId);

        return departamentoPropietarioDTO;
    }

    @Override
    public List<DepartamentoPropietarioDTO> obtenerDepartamentoPorEstado(String estado) {

        Estado estadoValor;

        try {
            estadoValor = Estado.valueOf(estado);
        } catch (Exception e) {
            throw new RecursoNoEncontrado("Ingrese un estado correcto (activo, inactivo)");
        }


        try {

            List<Departamentos> departamentosList = departamentosRepository.findDepartamentoPorEstado(estadoValor);

            List<DepartamentoPropietarioDTO> departamentoPropietarioDTOList =
                    departamentoPropietarioMapper.departamentoListADepartamentoPropietarioDTOList(departamentosList);
            return departamentoPropietarioDTOList;
        } catch (Exception e) {
            throw new DatabaseException("Error " + e);
        }

    }

    @Transactional(readOnly = true)
    @Override
    public List<DepartamentoPropietarioDTO> obtenerTodosLosDepartamentos() {

        List<Departamentos> departamentosList = departamentosRepository.findAll();

        List<DepartamentoPropietarioDTO> departamentoPropietarioDTOList = departamentoPropietarioMapper.departamentoListADepartamentoPropietarioDTOList(departamentosList);

        return departamentoPropietarioDTOList;
    }

    @Override
    public void eliminarDepartamento(Integer id) {

        Departamentos departamentosOptional = departamentosRepository.findById(id)
                .orElseThrow(() -> {
                    return new RecursoNoEncontrado("No existe el departamento");
                });

        departamentosRepository.deleteById(id);

    }
}
