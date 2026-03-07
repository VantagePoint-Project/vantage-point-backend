package com.vantagepoint.backend.application.user.factory;

import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.domain.user.model.User;

public class UserCreateFactory {
    public User executor(CreateUserCommand command) {
        return User.builder()
                .user(command.username())
                .email(command.email())
                .password(command.password())
                .build();
    }
}
