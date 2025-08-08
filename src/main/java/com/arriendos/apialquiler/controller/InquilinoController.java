package com.arriendos.apialquiler.controller;

import com.arriendos.apialquiler.model.dto.InquilinoDTO;
import com.arriendos.apialquiler.service.interfaces.InquilinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquilino/")
public class InquilinoController {

    private InquilinoService inquilinoService;

    @Autowired
    public InquilinoController(InquilinoService inquilinoService) {
        this.inquilinoService = inquilinoService;
    }

    @PostMapping("crearinquilino")
    public ResponseEntity<InquilinoDTO> guardarInquilino(@Valid @RequestBody InquilinoDTO inquilinoDTO){
        InquilinoDTO crear = inquilinoService.guardarInquilino(inquilinoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(crear);
    }

    @PutMapping("actualizarinquilino/{id}")
    public ResponseEntity<InquilinoDTO> actualizarInquilino(@PathVariable("id") Integer id, @Valid @RequestBody InquilinoDTO inquilinoDTO){
        InquilinoDTO actualizar = inquilinoService.actualizarInquilino(id,inquilinoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(actualizar);
    }

    @GetMapping("mostarinquilinoporId/{id}")
    public ResponseEntity<InquilinoDTO> mostarInquilinooPorId(@PathVariable("id") Integer id){
        InquilinoDTO mostratInquilino = inquilinoService.buscarInquilinoPorId(id);
        return ResponseEntity.ok(mostratInquilino);
    }

    @GetMapping("mostrartodoslosinquilinos")
    public ResponseEntity<List<InquilinoDTO> > mostrarTodosLosInquilinos(){
        List<InquilinoDTO> inquilinoDTOList = inquilinoService.obtenerTodosLosInquilinos();
        return ResponseEntity.ok(inquilinoDTOList);
    }

    @DeleteMapping("eliminarinquilino/{id}")
    public ResponseEntity<Void> eliminarInquilino(@PathVariable("id") Integer id){

        inquilinoService.eliminarInquilinoPorId(id);

        return ResponseEntity.noContent().build();
    }


}
