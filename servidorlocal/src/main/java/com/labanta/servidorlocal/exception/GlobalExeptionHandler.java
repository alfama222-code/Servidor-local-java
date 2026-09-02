package com.labanta.servidorlocal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(UtilizadorExistenteException.class)
    public ResponseEntity<?> tratarUtilizadorExistente(
            UtilizadorExistenteException ex) {

        Map<String, String> resposta = new HashMap<>();

        resposta.put(
                "mensagem",
                "Este username já está em uso, por favor escolha outro."
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(resposta);
    }
}