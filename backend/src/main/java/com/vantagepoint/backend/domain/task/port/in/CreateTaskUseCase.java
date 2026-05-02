package com.vantagepoint.backend.domain.task.port.in;

import com.vantagepoint.backend.domain.task.model.Task;

public interface CreateTaskUseCase {
    Task create(Task task);
}
