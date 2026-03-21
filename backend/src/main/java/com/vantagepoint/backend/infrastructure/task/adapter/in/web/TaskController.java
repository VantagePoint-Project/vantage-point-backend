package com.vantagepoint.backend.infrastructure.task.adapter.in.web;

import com.vantagepoint.backend.application.task.command.CreateTaskCommand;
import com.vantagepoint.backend.application.task.service.TaskApplicationService;
import com.vantagepoint.backend.domain.task.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskApplicationService taskApplicationService;

    @PostMapping
    public Task createTask(@RequestBody CreateTaskCommand command) {
        return taskApplicationService.execute(command);
    }
}
