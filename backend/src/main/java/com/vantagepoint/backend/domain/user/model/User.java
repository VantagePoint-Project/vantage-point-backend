package com.vantagepoint.backend.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.vantagepoint.backend.domain.common.validation.ArgumentValidator.validateLength;
import static com.vantagepoint.backend.domain.common.validation.ArgumentValidator.validateRegex;
import static com.vantagepoint.backend.domain.common.validation.ArgumentValidator.validateRequired;


@Getter
@AllArgsConstructor @NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public User(String username, String email, String password) {
        validateRequired(username, "The username is required.");
        validateRequired(email, "The email is required.");
        validateRequired(password, "The password is required.");
        validateLength(username, 3, "The username must be at least 3 characters long.");
        validateRegex(email, "^[A-Za-z0-9+_.-]+@(.+)$", "The email format is invalid.");

        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password) {
        validateRequired(password, "The password is required.");
        this.password = password;
    }
}
