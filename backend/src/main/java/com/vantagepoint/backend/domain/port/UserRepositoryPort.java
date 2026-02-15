package com.vantagepoint.backend.domain.port;

import com.vantagepoint.backend.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}