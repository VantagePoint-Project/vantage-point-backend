package com.vantagepoint.backend.infrastructure.user.adapter;

import com.vantagepoint.backend.domain.model.User;
import com.vantagepoint.backend.domain.port.UserRepositoryPort;
import com.vantagepoint.backend.infrastructure.user.adapter.persistence.SpringDataUserRepository;
import com.vantagepoint.backend.infrastructure.user.adapter.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserPersistenceAdapter implements UserRepositoryPort {
    private final SpringDataUserRepository springDataUserRepository;

    private final UserMapper userMapper;

    public UserPersistenceAdapter(SpringDataUserRepository springDataUserRepository,
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
