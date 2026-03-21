package com.vantagepoint.backend.infrastructure.common.adapter.in.web.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ApiResponse<T> {
    private final LocalDateTime timestamp;
    private final String message;
    private final T data;

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .timestamp(LocalDateTime.now())
                .message(message)
                .data(data)
                .build();
    }
}
