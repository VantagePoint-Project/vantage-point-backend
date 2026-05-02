package com.vantagepoint.backend.infrastructure.task.adapter.in.web;

import com.vantagepoint.backend.application.task.command.CreateTaskCommand;
import com.vantagepoint.backend.application.task.dto.TaskResponse;
import com.vantagepoint.backend.application.task.service.TaskApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TaskResponse> create(@RequestBody CreateTaskCommand command) {
        TaskResponse response = taskApplicationService.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
