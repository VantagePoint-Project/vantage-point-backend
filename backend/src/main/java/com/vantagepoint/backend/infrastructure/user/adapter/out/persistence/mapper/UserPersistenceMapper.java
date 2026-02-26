package com.vantagepoint.backend.infrastructure.user.adapter.out.persistence.mapper;

import com.vantagepoint.backend.domain.user.model.User;
import com.vantagepoint.backend.infrastructure.user.adapter.out.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {
    User toDomain(UserEntity entity);
    UserEntity toEntity(User user);
}
