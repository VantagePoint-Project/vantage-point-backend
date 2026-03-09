package com.vantagepoint.backend.domain.user.port.in;

import com.vantagepoint.backend.domain.user.model.User;

public interface CreateUserUseCase {
    User create(User user);
}
