package com.arriendos.apialquiler.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

    //errores en los campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInformacion> validationExceptions(MethodArgumentNotValidException ex, WebRequest webRequest) {
        Map<String, String> MapError = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
                    String clave = ((FieldError) error).getField();
                    String valor = error.getDefaultMessage();
                    MapError.put(clave, valor);
                }
        );
        ErrorInformacion errorInformacion = new ErrorInformacion(MapError.toString(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<ErrorInformacion> localNotFoundException(RecursoNoEncontrado ex, WebRequest webRequest) {
        ErrorInformacion errorInformacion = new ErrorInformacion("RecursoNoEncontrado " + ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorInformacion> handlerNoHandlerFoundException(NoHandlerFoundException ex, WebRequest webRequest) {
        ErrorInformacion errorInformacion = new ErrorInformacion("NoHandlerFoundException " + ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorInformacion> badRequestException(BadRequestException ex, WebRequest webRequest) {
        ErrorInformacion errorInformacion = new ErrorInformacion(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorInformacion> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest webRequest) {
        ErrorInformacion errorInformacion = new ErrorInformacion("MethodArgumentTypeMismatchException " + ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.BAD_REQUEST);
    }

    //"catch-all"
    //Devuelve un 500 INTERNAL_SERVER_ERROR
   @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInformacion> handlerException(Exception ex, WebRequest webRequest) {
        ErrorInformacion errorInformacion = new ErrorInformacion("Exception (Error inesperado)  " + ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorInformacion> errorTecnico(DatabaseException ex, WebRequest webRequest) {
        ErrorInformacion errorInformacion = new ErrorInformacion(ex.getMessage(),  webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorInformacion> erroNoSuchElement(NoSuchElementException ex, WebRequest webRequest) {
        ErrorInformacion errorInformacion = new ErrorInformacion("NoSuchElementException " + ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorInformacion, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
