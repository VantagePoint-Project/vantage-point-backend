package com.vantagepoint.backend.domain.task.port.out;

import com.vantagepoint.backend.domain.task.model.Task;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepositoryPort {
    Task save(Task task);

    Optional<Task> findById(UUID id);
}
