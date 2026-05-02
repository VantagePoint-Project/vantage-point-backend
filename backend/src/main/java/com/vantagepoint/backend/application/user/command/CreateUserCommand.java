package com.vantagepoint.backend.application.user.command;

import com.vantagepoint.backend.domain.common.exception.InvalidValueException;

public record CreateUserCommand(String username, String email, String password) {

}


