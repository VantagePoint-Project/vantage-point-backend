package com.vantagepoint.backend.architecture.user.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vantagepoint.backend.application.user.command.CreateUserCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Should return 201 Created when user is valid and saved in H2")
    void shouldCreateUserSuccessfully() throws Exception {
        CreateUserCommand command = new CreateUserCommand("stivinson", "test@vantage.com", "SecurePass123");

        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Should return 400 Bad Request when domain validation fails")
    void shouldReturn400WhenUsernameIsShort() throws Exception {
        // "st" tiene 2 letras, el validador pide 3.
        CreateUserCommand command = new CreateUserCommand("st", "test@vantage.com", "password");

        mockMvc.perform(post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(command)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("The username must be at least 3 characters long.")));
    }
}