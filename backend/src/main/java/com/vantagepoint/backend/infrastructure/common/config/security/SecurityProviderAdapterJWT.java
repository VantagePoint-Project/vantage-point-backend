package com.vantagepoint.backend.infrastructure.common.config.security;


import com.vantagepoint.backend.domain.common.port.SecurityProviderPort;
import com.vantagepoint.backend.domain.common.exception.UnauthorizedException;
import com.vantagepoint.backend.domain.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

@Component
public class SecurityProviderAdapterJWT implements SecurityProviderPort {

    private static final String EL_TOKEN_HA_EXPIRADO = "El token ha expirado";
    private static final String LA_FIRMA_DEL_TOKEN_NO_ES_VALIDA = "La firma del token no es válida";

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    @Override
    public String generateToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSignInKey())
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            final Claims claims = extractAllClaims(token);
            if (isTokenExpired(claims)) {
                throw new UnauthorizedException(EL_TOKEN_HA_EXPIRADO);
            }
            return true;
        } catch (io.jsonwebtoken.security.SignatureException e) {
            throw new UnauthorizedException(LA_FIRMA_DEL_TOKEN_NO_ES_VALIDA);
        } catch (io.jsonwebtoken.MalformedJwtException e) {
            throw new UnauthorizedException("El formato del token es incorrecto");
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getSubject(String token) {
        return extractAllClaims(token).getSubject();
    }

    @Override
    public Optional<String> getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        return Optional.of(authentication.getName());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}
