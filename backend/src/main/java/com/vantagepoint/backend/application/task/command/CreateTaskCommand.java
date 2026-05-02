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
        LocalDateTime dueDate) {

}