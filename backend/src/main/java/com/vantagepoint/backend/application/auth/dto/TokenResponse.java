package com.vantagepoint.backend.application.auth.dto;

public record TokenResponse(String accessToken, String tokenType) {
    public TokenResponse(String accessToken) {
        this(accessToken, "Bearer");
    }
}
