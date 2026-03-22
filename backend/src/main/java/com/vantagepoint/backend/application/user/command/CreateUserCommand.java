package com.vantagepoint.backend.application.user.command;

/**
 * Comando para la creación de un usuario.
 * Solo contiene datos, no lógica.
 */
public record CreateUserCommand(
        String userName,
        String email,
        String password
) {}


