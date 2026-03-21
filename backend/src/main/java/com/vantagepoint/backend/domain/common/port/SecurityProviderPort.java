package com.vantagepoint.backend.domain.common.port;

import com.vantagepoint.backend.domain.user.model.User;

import java.util.Optional;

public interface SecurityProviderPort {
    // Genera el string del Token (JWT) para un usuario
    String generateToken(User user);

    // Valida si el string del token es auténtico y no ha expirado
    boolean validateToken(String token);

    // Extrae el username o ID del token
    String getSubject(String token);

    // (Opcional por ahora) Obtener el usuario autenticado del contexto
    Optional<String> getAuthenticatedUserId();
}
