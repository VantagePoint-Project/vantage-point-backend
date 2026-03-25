package com.vantagepoint.backend.domain.common.validation;

import com.vantagepoint.backend.domain.common.exception.InvalidValueException;

public final class ArgumentValidator {

    private ArgumentValidator() {
        // Private constructor to prevent instantiation
    }

    public static void validateRequired(Object value, String message) {
        // Aquí declaras la variable 's' (o el nombre que prefieras) directamente
        if (value == null || (value instanceof String s && s.isBlank())) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateLength(String value, int minLength, String message) {
        if (value != null && value.length() < minLength) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateRegex(String value, String regex, String message) {
        if (value == null || !value.matches(regex)) {
            throw new InvalidValueException(message);
        }
    }
}