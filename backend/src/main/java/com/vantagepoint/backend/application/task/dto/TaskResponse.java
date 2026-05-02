package com.vantagepoint.backend.application.task.dto;

import com.vantagepoint.backend.domain.task.model.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponse(
        UUID id,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime dueDate
) {}
