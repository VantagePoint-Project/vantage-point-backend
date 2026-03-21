package com.vantagepoint.backend.infrastructure.user.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vantagepoint.backend.application.auth.command.LoginCommand;
import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.out.UserRepositoryPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepositoryPort userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("Debe retornar un token cuando las credenciales son válidas")
    void shouldReturnTokenWhenCredentialsAreValidTest() throws Exception {
        String rawPassword = "password123";
        User user = new User("stivinson", "test@vantage.com", passwordEncoder.encode(rawPassword));
        userRepository.save(user);

        LoginCommand loginCommand = new LoginCommand("stivinson", rawPassword);

        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginCommand)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").exists())
                .andExpect(jsonPath("$.message").value("Login exitoso"));
    }

    @Test
    @DisplayName("Debe retornar 401 cuando la contraseña es incorrecta")
    void shouldReturn401WhenPasswordIsWrongTest() throws Exception {
        LoginCommand loginRequest = new LoginCommand("stivinson", "clave_erronea");

        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))

                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.name").value("UnauthorizedException"));
    }
}