package com.vantagepoint.backend.domain.common.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {
    protected DomainException(String message) {
        super(message);
    }
}
