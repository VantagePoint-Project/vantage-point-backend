package com.vantagepoint.backend.application.user.command;

import com.vantagepoint.backend.domain.common.exception.InvalidValueException;

public record CreateUserCommand(String username, String email, String password) {
    public CreateUserCommand {

        //**VALIDACIÓN: username obligatorio**
        if (username == null || username.isBlank()) {
            throw new InvalidValueException("Username is required");
        }

        // **VALIDACIÓN: email obligatorio**
        if (email == null || email.isBlank()) {
            throw new InvalidValueException("Email is required");
        }

        //**VALIDACIÓN: password obligatorio**
        if (password == null || password.isBlank()) {
            throw new InvalidValueException("Password is required");
        }

        // **MEJORA: validación básica de formato email**
        if (!email.contains("@")) {
            throw new InvalidValueException("Invalid email format");
        }

        // **MEJORA: longitud mínima password**
        if (password.length() < 6) {
            throw new InvalidValueException("Password must be at least 6 characters");
        }
    }
}


