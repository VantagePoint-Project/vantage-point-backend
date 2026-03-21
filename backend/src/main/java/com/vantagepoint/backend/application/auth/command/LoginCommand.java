package com.vantagepoint.backend.application.auth.command;

import com.vantagepoint.backend.domain.common.exception.InvalidValueException;

public record LoginCommand(String username, String password) {
    public LoginCommand {
        if (username == null || username.isBlank()) throw new InvalidValueException("Username is required");
    }
}
