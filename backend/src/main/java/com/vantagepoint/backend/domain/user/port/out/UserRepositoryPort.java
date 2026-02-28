package com.vantagepoint.backend.domain.user.port.out;

import com.vantagepoint.backend.domain.user.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}