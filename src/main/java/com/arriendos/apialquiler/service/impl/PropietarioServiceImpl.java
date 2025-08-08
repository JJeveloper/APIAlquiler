package com.arriendos.apialquiler.service.impl;

import com.arriendos.apialquiler.model.dto.PropietarioDTO;
import com.arriendos.apialquiler.model.entity.Departamentos;
import com.arriendos.apialquiler.model.entity.Propietario;
import com.arriendos.apialquiler.model.exception.BadRequestException;
import com.arriendos.apialquiler.model.exception.DatabaseException;
import com.arriendos.apialquiler.model.exception.RecursoNoEncontrado;
import com.arriendos.apialquiler.model.mapper.PropietarioMapper;
import com.arriendos.apialquiler.repository.DepartamentosRepository;
import com.arriendos.apialquiler.repository.PropietarioRepository;
import com.arriendos.apialquiler.service.interfaces.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    private PropietarioRepository propietarioRepository;
    private DepartamentosRepository departamentosRepository;
    private PropietarioMapper propietarioMapper;

    @Autowired
    public PropietarioServiceImpl(PropietarioRepository propietarioRepository, PropietarioMapper propietarioMapper, DepartamentosRepository departamentosRepository) {
        this.propietarioRepository = propietarioRepository;
        this.propietarioMapper = propietarioMapper;
        this.departamentosRepository = departamentosRepository;
    }

    @Override
    @Transactional // Transacción de escritura (commit o rollback)
    public PropietarioDTO guardarPropietario(PropietarioDTO propietarioDTO) {

        try {
            Propietario propietario = propietarioMapper.propietarioDTOAPropietario(propietarioDTO);

            Propietario propietarioGuardado = propietarioRepository.save(propietario);

            return propietarioMapper.propietarioAPropietarioDTO(propietarioGuardado);
        } catch (Exception e) {
            throw new RecursoNoEncontrado("No existe el recurso");
        }

    }

    @Override
    @Transactional // Transacción de escritura (commit o rollback)
    public PropietarioDTO actualizarPropietario(Integer id, PropietarioDTO propietarioDTO) {


        Optional<Propietario> propietarioOptional = propietarioRepository.findById(id);
        if (propietarioOptional.isPresent()) {


            Propietario propietario = propietarioOptional.get();

            propietario.setNombres(propietarioDTO.getNombres());
            propietario.setTelefono(propietarioDTO.getTelefono());

            propietarioRepository.save(propietario);

            PropietarioDTO actualizado = propietarioMapper.propietarioAPropietarioDTO(propietario);

            return actualizado;

        } else {

            throw new RecursoNoEncontrado("No existe el recurso");

        }

    }

    @Override
    @Transactional(readOnly = true)
    public PropietarioDTO buscarPropietarioPorId(Integer id) {

        Optional<Propietario> propietarioID = propietarioRepository.findById(id);

        if (propietarioID.isEmpty()) {
            throw new RecursoNoEncontrado("No existe el recurso");
        }

        PropietarioDTO propietarioDTO = propietarioMapper.propietarioAPropietarioDTO(propietarioID.get());

        return propietarioDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PropietarioDTO> obtenerTodosLosPropietarios() {

        List<Propietario> propietarioList = propietarioRepository.findAll();

        List<PropietarioDTO> propietarioDTOList = propietarioMapper.propietarioListAPropietarioDTOList(propietarioList);

        return propietarioDTOList;
    }

    @Override
    @Transactional // Transacción de escritura (commit o rollback)
    public void eliminarPropietarioPorID(Integer id) {

        Propietario proietarioID = propietarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("No existe el propietario"));

        List<Departamentos> departamentos = departamentosRepository.findAll();

        for (int i = 0; i < departamentos.size(); i++) {

            int idPropietarioDepartamentos = departamentos.get(i).getPropietario().getIdpropietario();

            if (idPropietarioDepartamentos == proietarioID.getIdpropietario()) {
                throw new BadRequestException("No se puede eliminar el propietario, tiene registrado departamentos");
            }

        }

        try {
            propietarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new DatabaseException("No se puede eliminar el propietario");
        }

    }
}
