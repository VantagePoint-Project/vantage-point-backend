package com.vantagepoint.backend.application.user.service;

import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.application.user.dto.UserResponse;
import com.vantagepoint.backend.application.user.factory.UserCreateFactory;
import com.vantagepoint.backend.domain.common.exception.InvalidValueException;
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

    //**CREACIÓN MANUAL (sin Spring)**
    private final UserCreateFactory userCreateFactory = new UserCreateFactory();

    @Transactional
    public UserResponse execute(CreateUserCommand command) {

        //**VALIDACIÓN: usuario existente**
        userRepositoryPort.findByUsername(command.username())
                .ifPresent(u -> {
                    throw new InvalidValueException("Username already exists");
                });

        User user = userCreateFactory.execute(command);

        //**SEGURIDAD: hash de password**
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepositoryPort.save(user);

        //**RETORNAR DTO (NO dominio)**
        return new UserResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

}
