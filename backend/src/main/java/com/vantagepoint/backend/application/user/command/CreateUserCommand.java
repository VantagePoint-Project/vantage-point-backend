package com.vantagepoint.backend.application.user.command;

import lombok.Getter;

@Getter
public class CreateUserCommand {
    private final String username;
    private final String email;
    private final String password;

    public CreateUserCommand(String username, String email, String password) {
        // VALIDACIÓN: Evitamos que el comando se cree con datos inválidos
        if (username == null || username.isBlank()) throw new IllegalArgumentException("Username is required");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password is required");

        this.username = username;
        this.email = email;
        this.password = password;
    }
}


