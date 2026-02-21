package com.vantagepoint.backend.infrastructure.user.adapter;

import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.UserRepositoryPort;
import com.vantagepoint.backend.infrastructure.user.adapter.persistence.SpringDataUserRepository;
import com.vantagepoint.backend.infrastructure.user.adapter.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserPersistenceAdapterJpa implements UserRepositoryPort {
    private final SpringDataUserRepository springDataUserRepository;

    private final UserMapper userMapper;

    public UserPersistenceAdapterJpa(SpringDataUserRepository springDataUserRepository,
                                     UserMapper userMapper) {
        this.springDataUserRepository = springDataUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
