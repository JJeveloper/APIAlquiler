package com.arriendos.apialquiler.controller;

import com.arriendos.apialquiler.model.dto.ContratoDTO;
import com.arriendos.apialquiler.service.interfaces.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato/")
public class ContratoController {

    private ContratoService contratoService;

    @Autowired
    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping("crearcontrato")
    public ResponseEntity<ContratoDTO> guardarContrato(@Valid @RequestBody ContratoDTO contratoDTO) {
        ContratoDTO crearContacto = contratoService.guardarContrato(contratoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(crearContacto);
    }

    @GetMapping("mostrarcontratoporid/{id}")
    public ResponseEntity<ContratoDTO> mostrarContratoPorId(@PathVariable("id") Integer id) {
        ContratoDTO mostrarPorId = contratoService.buscarContratoPorId(id);
        return ResponseEntity.ok(mostrarPorId);
    }

    @GetMapping("mostrartodosloscontratos")
    public ResponseEntity<List<ContratoDTO>> mostrarTodosLosContratos() {
        List<ContratoDTO> contratoDTOList = contratoService.obtenerTodosLosContratos();
        return ResponseEntity.ok(contratoDTOList);
    }

    @DeleteMapping("eliminarcontrato/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable("id") Integer id){
        contratoService.eliminarContrato(id);
        return ResponseEntity.noContent().build();
    }


}
