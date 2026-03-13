package com.vantagepoint.backend.domain.common.exception;

import org.springframework.http.HttpStatus;

public class InvalidValueException extends DomainException {
    public InvalidValueException(String message) {
        super(message);
    }
}