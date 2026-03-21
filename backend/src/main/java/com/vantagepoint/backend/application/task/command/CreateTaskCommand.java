package com.vantagepoint.backend.application.task.command;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class CreateTaskCommand {

    private Long userId;
    private String title;
    private String description;
    private LocalDateTime dueDate;
}
