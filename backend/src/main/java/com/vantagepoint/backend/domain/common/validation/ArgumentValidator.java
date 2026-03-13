package com.vantagepoint.backend.domain.common.validation;

import com.vantagepoint.backend.domain.common.exception.InvalidValueException;

public final class ArgumentValidator {

    private ArgumentValidator() {
        // Private constructor to prevent instantiation
    }

    public static void validateRequired(Object value, String message) {
        if (value == null || (value instanceof String && ((String) value).isBlank())) {
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