package com.example.meusgastoscaldas.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.meusgastoscaldas.common.ConversorData;
import com.example.meusgastoscaldas.domain.exception.ResourceNotFoundException;
import com.example.meusgastoscaldas.domain.model.ErroResposta;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResposta> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String dataHora = ConversorData.converterDataParaDataHora(new Date());
        ErroResposta erro = new ErroResposta(dataHora, HttpStatus.BAD_REQUEST.value(), "BAD REQUEST", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}
