package com.vantagepoint.backend.infrastructure.user.adapter.in.web;

import com.vantagepoint.backend.application.auth.command.LoginCommand;
import com.vantagepoint.backend.application.auth.dto.TokenResponse;
import com.vantagepoint.backend.application.auth.service.AuthApplicationService;
import com.vantagepoint.backend.infrastructure.common.adapter.in.web.dtos.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final String LOGIN_EXITOSO = "Login exitoso";
    private final AuthApplicationService authApplicationService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@RequestBody LoginCommand loginCommand) {

        TokenResponse tokenResponse = authApplicationService.login(loginCommand);

        return ResponseEntity.ok(
                ApiResponse.success(tokenResponse, LOGIN_EXITOSO)
        );
    }
}