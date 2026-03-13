package com.vantagepoint.backend.infrastructure.common.adapter.in.web.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ErrorResponse {
    private final LocalDateTime timestamp;
    private final String message;
    private final String name;
    private final List<String> details;
}
