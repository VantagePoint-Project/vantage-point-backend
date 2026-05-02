package com.vantagepoint.backend.application.user.service;

import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import com.vantagepoint.backend.application.user.dto.UserResponse;
import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.out.UserRepositoryPort;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserApplicationServiceTest {

    @Mock
    private UserRepositoryPort userRepositoryPort;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserApplicationService userApplicationService;

    public UserApplicationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateUserSuccessfullyTest() {

        // 🔹 Arrange
        CreateUserCommand command = new CreateUserCommand(
                "admin",
                "admin@mail.com",
                "123456"
        );

        User user = new User(command.username(),command.email(), command.password());

        when(userRepositoryPort.findByUsername("admin"))
                .thenReturn(Optional.empty());

        when(userRepositoryPort.save(any()))
                .thenReturn(user);


        when(passwordEncoder.encode(any()))
                .thenReturn("hashed_password");

        // 🔹 Act
        UserResponse response = userApplicationService.execute(command);

        // 🔹 Assert
        assertNotNull(response);
        assertEquals("admin", response.username());

        verify(userRepositoryPort, times(1)).save(any());
    }
}
