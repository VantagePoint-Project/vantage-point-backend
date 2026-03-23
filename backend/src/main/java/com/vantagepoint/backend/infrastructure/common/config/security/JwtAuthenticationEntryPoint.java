package com.vantagepoint.backend.infrastructure.common.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vantagepoint.backend.infrastructure.common.adapter.in.web.dtos.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message("No estás autorizado para acceder a este recurso. Token inválido o ausente.")
                .name("UnauthorizedException")
                .details(Collections.emptyList())
                .build();

        final String responseBody = objectMapper.writeValueAsString(error);
        response.getWriter().write(responseBody);
    }
}
