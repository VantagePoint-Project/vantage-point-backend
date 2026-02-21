package com.vantagepoint.backend.application.user.command;

import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.UserRepositoryPort;
import com.vantagepoint.backend.domain.user.port.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateUserHandler implements CreateUserUseCase {

    private final UserRepositoryPort userRepository;

    @Override
    public User handle(CreateUserCommand command) {
        // Transformación: Command -> Domain Model
        User user = User.builder()
                .username(command.getUsername())
                .email(command.getEmail())
                .passwordHash(command.getPassword()) // Aquí encriptarás después
                .createdAt(LocalDateTime.now())     // Cálculo de fecha de creación
                .build();

        return userRepository.save(user);
    }
}
