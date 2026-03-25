package com.vantagepoint.backend.application.user.command;

public record CreateUserCommand(
        String username,
        String email,
        String password
) {}


