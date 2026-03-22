package com.vantagepoint.backend.infrastructure.task.adapter.in.web.dto;

import java.time.LocalDateTime;

public record CreateTaskRequest(
        Long userId,
        String title,
        String description,
        LocalDateTime dueDate
) {}
