package com.vantagepoint.backend.infrastructure.common.adapter.in.web.advice;

import com.vantagepoint.backend.domain.common.exception.DomainException;
import com.vantagepoint.backend.domain.common.exception.GeneralServiceException;
import com.vantagepoint.backend.domain.common.exception.InvalidValueException;
import com.vantagepoint.backend.infrastructure.common.adapter.in.web.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Map<String, HttpStatus> STATUS_CODE = new HashMap<>();

    static {
        // Matrícula de tus excepciones de negocio (400)
        STATUS_CODE.put(InvalidValueException.class.getSimpleName(), HttpStatus.BAD_REQUEST);
        STATUS_CODE.put(GeneralServiceException.class.getSimpleName(), HttpStatus.BAD_REQUEST);

        // Matrícula de excepciones de sistema

    }
    // 1. Errores de Negocio Controlados
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException exception) {
        String name = exception.getClass().getSimpleName();
        HttpStatus status = STATUS_CODE.get(name);

        if (status == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return buildResponse("Error interno del servidor", "INTERNAL_ERROR", status);
        }

        return buildResponse(exception.getMessage(), name, status);
    }

    // 2. Errores NO Controlados (500) - El "Catch-All"
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        return buildResponse(
                "Ha ocurrido un error inesperado en el servidor",
                "INTERNAL_SERVER_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    private ResponseEntity<ErrorResponse> buildResponse(String message, String name, HttpStatus status) {
        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(message)
                .name(name)
                .details(Collections.emptyList())
                .build();
        return new ResponseEntity<>(error, status);
    }

}
