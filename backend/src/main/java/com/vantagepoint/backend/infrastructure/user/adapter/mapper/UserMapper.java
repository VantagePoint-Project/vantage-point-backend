package com.vantagepoint.backend.infrastructure.user.adapter.mapper;

import com.vantagepoint.backend.domain.user.model.User;

import com.vantagepoint.backend.infrastructure.user.adapter.UserEntity;
import org.springframework.stereotype.Component;

@Component

public class UserMapper {

    public UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPasswordHash(user.getPasswordHash());

        return entity;
    }

    public User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .passwordHash(entity.getPasswordHash())
                .build();
    }
}
