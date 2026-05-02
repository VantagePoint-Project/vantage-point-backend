package com.vantagepoint.backend.application.user.dto;

public record UserResponse(
        Long id,
        String username,
        String email
) {}