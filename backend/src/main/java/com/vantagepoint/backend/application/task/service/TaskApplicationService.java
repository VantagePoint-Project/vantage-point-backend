package com.vantagepoint.backend.application.task.service;

import com.vantagepoint.backend.application.task.command.CreateTaskCommand;
import com.vantagepoint.backend.domain.task.model.Task;
import com.vantagepoint.backend.domain.task.model.TaskStatus;
import com.vantagepoint.backend.domain.task.port.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskApplicationService {
    private final TaskRepositoryPort taskRepository;
    public Task execute(CreateTaskCommand command) {

        Task task = Task.builder()
                .id(UUID.randomUUID())
                .userId(command.getUserId())
                .title(command.getTitle())
                .description(command.getDescription())
                .status(TaskStatus.PENDING)
                .dueDate(command.getDueDate())
                .build();

        return taskRepository.save(task);
    }

}
