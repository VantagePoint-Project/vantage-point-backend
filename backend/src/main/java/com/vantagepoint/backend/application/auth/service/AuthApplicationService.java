package com.vantagepoint.backend.application.auth.service;

import com.vantagepoint.backend.application.auth.command.LoginCommand;
import com.vantagepoint.backend.application.auth.dto.TokenResponse;
import com.vantagepoint.backend.domain.common.port.SecurityProviderPort;
import com.vantagepoint.backend.domain.common.exception.UnauthorizedException;
import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.out.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthApplicationService {

    private final UserRepositoryPort userRepository;
    private final SecurityProviderPort securityProvider;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse login(LoginCommand loginCommand) {

        String username = loginCommand.username();
        String password = loginCommand.password();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("Usuario o contraseña incorrectos"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("Usuario o contraseña incorrectos");
        }
        String token = securityProvider.generateToken(user);
        return new TokenResponse(token);
    }
}
