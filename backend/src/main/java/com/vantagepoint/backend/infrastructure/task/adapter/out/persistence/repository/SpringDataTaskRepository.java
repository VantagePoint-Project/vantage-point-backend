package com.vantagepoint.backend.infrastructure.task.adapter.out.persistence.repository;

import com.vantagepoint.backend.infrastructure.task.adapter.out.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataTaskRepository extends JpaRepository<TaskEntity, UUID> {

    // Este método lo necesitaremos para listar las tareas de un usuario específico
    List<TaskEntity> findByUserId(Long userId);
}
