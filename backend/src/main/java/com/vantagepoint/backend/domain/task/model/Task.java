package com.vantagepoint.backend.domain.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.vantagepoint.backend.domain.common.validation.ArgumentValidator.validateLength;
import static com.vantagepoint.backend.domain.common.validation.ArgumentValidator.validatePositive;
import static com.vantagepoint.backend.domain.common.validation.ArgumentValidator.validateRegex;
import static com.vantagepoint.backend.domain.common.validation.ArgumentValidator.validateRequired;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class Task {

    private UUID id;
    private Long userId;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime dueDate;

    @Builder
    public Task(Long userId,String title, String description,LocalDateTime dueDate) {
        validateRequired(title, "The title is required.");
        validateRequired(description, "The description is required.");
        validateRequired(dueDate, "The dueDate is required.");
        validateRequired(userId, "The userId is required.");
        validateLength(title, 3, "The title must be at least 3 characters long.");
        validateLength(description,10, "The title must be at least 10 characters long.");
        validatePositive(userId, "The userId must be a positive number.");

        this.title = title;
        this.description = description;
        this.userId = userId;
        this.id = UUID.randomUUID();
        this.status = TaskStatus.PENDING;
        this.dueDate = dueDate;

    }
}
