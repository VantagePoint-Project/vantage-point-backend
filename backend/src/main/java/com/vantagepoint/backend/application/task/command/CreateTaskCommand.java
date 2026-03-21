package com.vantagepoint.backend.application.task.command;

import java.time.LocalDateTime;

public record CreateTaskCommand(
        Long userId,
        String title,
        String description,
        LocalDateTime dueDate
) {}