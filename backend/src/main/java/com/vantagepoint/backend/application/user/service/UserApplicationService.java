package com.vantagepoint.backend.application.user.service;

import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.application.user.factory.UserCreateFactory;
import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.out.UserRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepositoryPort userRepositoryPort;
    private final UserCreateFactory userCreateFactory;


    @Transactional
    public User handle(CreateUserCommand command) {
        User user = userCreateFactory.executor(command);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepositoryPort.save(user);
    }

}
