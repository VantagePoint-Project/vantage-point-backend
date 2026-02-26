package com.vantagepoint.backend.infrastructure.user.adapter.out.persistence.repository;



import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.domain.user.port.out.UserRepositoryPort;
import com.vantagepoint.backend.infrastructure.user.adapter.out.persistence.entity.UserEntity;
import com.vantagepoint.backend.infrastructure.user.adapter.out.persistence.mapper.UserPersistenceMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserRepositoryPortJpa implements UserRepositoryPort {

    private final SpringDataUserRepository springDataUserRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    public UserRepositoryPortJpa(SpringDataUserRepository springDataUserRepository,
                                 UserPersistenceMapper userPersistenceMapper) {
        this.springDataUserRepository = springDataUserRepository;
        this.userPersistenceMapper = userPersistenceMapper;
    }


    @Override
    public User save(User user) {
        // 1. Dominio -> Entidad
        UserEntity entity = userPersistenceMapper.toEntity(user);
        // 2. Guardar en DB
        UserEntity savedEntity = springDataUserRepository.save(entity);
        // 3. Entidad -> Dominio
        return userPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email)
                .map(userPersistenceMapper::toDomain);
    }
}
