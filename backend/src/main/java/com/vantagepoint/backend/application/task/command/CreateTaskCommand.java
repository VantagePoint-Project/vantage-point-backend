package com.vantagepoint.backend.application.task.command;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vantagepoint.backend.domain.common.exception.InvalidValueException;
import com.vantagepoint.backend.infrastructure.common.config.jackson.CustomLocalDateTimeDeserializer;

import java.time.LocalDateTime;

public record CreateTaskCommand(
        Long userId,
        String title,
        String description,

        @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
        LocalDateTime dueDate
) {
    public CreateTaskCommand {
        //**VALIDACIÓN: userId obligatorio**
        if (userId == null) {
            throw new InvalidValueException("UserId is required");
        }
        // **VALIDACIÓN: title obligatorio**
        if (title == null || title.isBlank()) {
            throw new InvalidValueException("Title is required");
        }
        // **VALIDACIÓN: fecha no nula**
        if (dueDate == null) {
            throw new InvalidValueException("Due date is required");
        }
    }
}