package com.vantagepoint.backend.application.service;

import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepositoryPort userRepository;

    public User execute(String username, String email, String password) {

        User user = User.builder()
                .username(username)
                .email(email)
                .passwordHash(password)
                .build();

        return userRepository.save(user);
    }
}
