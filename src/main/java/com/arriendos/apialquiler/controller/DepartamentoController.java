package com.arriendos.apialquiler.controller;

import com.arriendos.apialquiler.model.dto.DepartamentoPropietarioDTO;
import com.arriendos.apialquiler.model.entity.Estado;
import com.arriendos.apialquiler.service.impl.DepartamentoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/departamento/"))
public class DepartamentoController {

    private DepartamentoServiceImpl departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoServiceImpl departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping("creardepartamento")
    public ResponseEntity<DepartamentoPropietarioDTO> guardarDepartamento(@Valid @RequestBody DepartamentoPropietarioDTO departamentoDTO) {
        DepartamentoPropietarioDTO guardar = departamentoService.guardarDepartamento(departamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardar);
    }

    @PutMapping("actualizardepartamento/{id}")
    public ResponseEntity<DepartamentoPropietarioDTO> actualizarDepartamento(@PathVariable("id") Integer id,@Valid @RequestBody DepartamentoPropietarioDTO departamentoDTO) {
        DepartamentoPropietarioDTO actualizar = departamentoService.actualizarDepartamento(id, departamentoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(actualizar);
    }

    @GetMapping("mostrardepartamentoporid/{id}")
    public ResponseEntity<DepartamentoPropietarioDTO> mostrarDepartamentoPorId(@PathVariable("id") Integer id) {
        DepartamentoPropietarioDTO mostarPorId = departamentoService.buscarDepartamentoPorId(id);
        return ResponseEntity.ok(mostarPorId);
    }

    @GetMapping("mostrardepartamentoporestado/{estado}")
    public ResponseEntity<List<DepartamentoPropietarioDTO>> mostrarDepartamentoPorEstado(@PathVariable("estado")String estado){
        List<DepartamentoPropietarioDTO> porEstadoList = departamentoService.obtenerDepartamentoPorEstado(estado);
        return ResponseEntity.ok(porEstadoList);
    }

    @GetMapping("mostrartodoslosdepartamentos")
    public ResponseEntity<List<DepartamentoPropietarioDTO>> mostrarTodosLosDepartamentos() {
        List<DepartamentoPropietarioDTO> list = departamentoService.obtenerTodosLosDepartamentos();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("eliminardepartamento/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable("id") Integer id){
        departamentoService.eliminarDepartamento(id);
        return ResponseEntity.noContent().build();
    }


}
