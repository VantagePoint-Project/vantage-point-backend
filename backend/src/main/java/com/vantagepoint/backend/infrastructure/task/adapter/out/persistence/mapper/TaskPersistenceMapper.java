package com.vantagepoint.backend.infrastructure.task.adapter.out.persistence.mapper;

import com.vantagepoint.backend.domain.task.model.Task;
import com.vantagepoint.backend.infrastructure.task.adapter.out.persistence.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskPersistenceMapper {
    Task toDomain(TaskEntity entity);
    TaskEntity toEntity(Task task);
}
