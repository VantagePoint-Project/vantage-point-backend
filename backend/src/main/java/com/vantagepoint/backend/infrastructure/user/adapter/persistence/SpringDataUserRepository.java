package com.vantagepoint.backend.infrastructure.user.adapter.persistence;

import com.vantagepoint.backend.infrastructure.user.adapter.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
