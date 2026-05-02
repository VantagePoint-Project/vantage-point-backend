package com.vantagepoint.backend.infrastructure.task.adapter.out.persistence.repository;

import com.vantagepoint.backend.domain.task.model.Task;
import com.vantagepoint.backend.domain.task.port.out.TaskRepositoryPort;
import com.vantagepoint.backend.infrastructure.task.adapter.out.persistence.mapper.TaskPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TaskPersistenceAdapter implements TaskRepositoryPort {

    private final SpringDataTaskRepository repository;
    private final TaskPersistenceMapper mapper;

    @Override
    public Task save(Task task) {
        var entity = mapper.toEntity(task);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return Optional.empty();
    }
}
