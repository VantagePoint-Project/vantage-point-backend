package com.vantagepoint.backend.domain.model;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class User {
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private List<Habit> habits; // Relación 1:N
}
