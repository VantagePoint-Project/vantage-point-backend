package com.vantagepoint.backend.domain.user.port.in;

import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.domain.user.model.User;

public interface CreateUserUseCase {
    User handle(CreateUserCommand command);
}
