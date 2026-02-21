package com.vantagepoint.backend.domain.habit.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Habit {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private String frequency; // DAILY, WEEKLY, etc.
    private boolean isActive;
}