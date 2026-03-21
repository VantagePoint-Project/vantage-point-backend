package com.vantagepoint.backend.application.task.factory;

import com.vantagepoint.backend.application.task.command.CreateTaskCommand;
import com.vantagepoint.backend.domain.task.model.Task;
import com.vantagepoint.backend.domain.task.model.TaskStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TaskCreateFactory {

    public Task execute(CreateTaskCommand command) {
        return Task.builder()
                .id(UUID.randomUUID())
                .userId(command.userId())
                .title(command.title())
                .description(command.description())
                .status(TaskStatus.PENDING)
                .dueDate(command.dueDate())
                .build();
    }
}
