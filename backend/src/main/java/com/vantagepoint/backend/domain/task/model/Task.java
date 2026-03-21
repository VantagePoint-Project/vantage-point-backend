package com.vantagepoint.backend.domain.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Task {

    private UUID id;
    private Long userId;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime dueDate;
}
