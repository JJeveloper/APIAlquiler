package com.arriendos.apialquiler.controller;

import com.arriendos.apialquiler.model.dto.PropietarioDTO;
import com.arriendos.apialquiler.service.interfaces.PropietarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietario/")
public class PropietarioController {

    private PropietarioService propietarioService;

    @Autowired
    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping("crearpropietario")
    public ResponseEntity<PropietarioDTO> guardarPropietario(@Valid @RequestBody PropietarioDTO propietarioDTO) {
        PropietarioDTO crear = propietarioService.guardarPropietario(propietarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(crear);
    }

    @PutMapping("actualizarpropietario/{id}")
    public ResponseEntity<PropietarioDTO> actualizarPropietario(@PathVariable("id") Integer id, @Valid @RequestBody PropietarioDTO propietarioDTO) {
        PropietarioDTO actulizarPropietario = propietarioService.actualizarPropietario(id, propietarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(actulizarPropietario);

    }

    @GetMapping("mostarpropietarioporId/{id}")
    public ResponseEntity<PropietarioDTO> mostarPropietarioPorId(@PathVariable("id") Integer id) {
        PropietarioDTO propietarioDTO = propietarioService.buscarPropietarioPorId(id);

        return ResponseEntity.ok(propietarioDTO);
    }


    @GetMapping("mostrartodoslospropietarios")
    public ResponseEntity<List<PropietarioDTO>> mostrartodoslospropietarios() {

        List<PropietarioDTO> propietarioDTOList = propietarioService.obtenerTodosLosPropietarios();

        return ResponseEntity.ok(propietarioDTOList);
    }

    @DeleteMapping("eliminarpropietario/{id}")
    public ResponseEntity<Void> eliminarPropietrrioPorId(@PathVariable("id") Integer id) {

        propietarioService.eliminarPropietarioPorID(id);
        return ResponseEntity.noContent().build();

    }

}
