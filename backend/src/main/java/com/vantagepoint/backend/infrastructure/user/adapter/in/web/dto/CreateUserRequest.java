package com.vantagepoint.backend.infrastructure.user.adapter.in.web.dto;

public record CreateUserRequest(
        String username,
        String email,
        String password
) {}