package com.vantagepoint.backend.application.task.service;

import com.vantagepoint.backend.application.task.command.CreateTaskCommand;
import com.vantagepoint.backend.application.task.factory.TaskCreateFactory;
import com.vantagepoint.backend.domain.task.model.Task;
import com.vantagepoint.backend.domain.task.port.out.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskApplicationService {

    private final TaskRepositoryPort taskRepository;
    private final TaskCreateFactory taskCreateFactory;

    public Task execute(CreateTaskCommand command) {

        Task task = taskCreateFactory.execute(command);

        return taskRepository.save(task);
    }

}
