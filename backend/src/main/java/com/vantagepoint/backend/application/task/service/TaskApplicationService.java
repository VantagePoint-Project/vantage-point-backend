package com.vantagepoint.backend.application.task.service;

import com.vantagepoint.backend.application.task.command.CreateTaskCommand;
import com.vantagepoint.backend.application.task.dto.TaskResponse;
import com.vantagepoint.backend.application.task.factory.TaskCreateFactory;
import com.vantagepoint.backend.domain.task.model.Task;
import com.vantagepoint.backend.domain.task.port.out.TaskRepositoryPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskApplicationService {

    private final TaskRepositoryPort taskRepository;
    private final TaskCreateFactory taskCreateFactory = new TaskCreateFactory();

    public TaskResponse handle(CreateTaskCommand command) {
        Task task = taskCreateFactory.execute(command);
        Task savedTask = taskRepository.save(task);

        return new TaskResponse(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.getStatus(),
                savedTask.getDueDate()
        );
    }
}
