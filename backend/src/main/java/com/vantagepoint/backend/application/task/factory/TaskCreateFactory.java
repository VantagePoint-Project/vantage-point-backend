package com.vantagepoint.backend.application.task.factory;

import com.vantagepoint.backend.application.task.command.CreateTaskCommand;
import com.vantagepoint.backend.domain.task.model.Task;
import com.vantagepoint.backend.domain.task.model.TaskStatus;
import java.util.UUID;

public class TaskCreateFactory {

    public Task execute(CreateTaskCommand command) {
        return Task.builder()
                .userId(command.userId())
                .title(command.title())
                .description(command.description())
                .dueDate(command.dueDate())
                .build();
    }
}
