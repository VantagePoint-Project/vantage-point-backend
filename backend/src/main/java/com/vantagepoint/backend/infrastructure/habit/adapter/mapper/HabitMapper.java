package com.vantagepoint.backend.infrastructure.habit.adapter.mapper;

import com.vantagepoint.backend.domain.model.Habit;
import com.vantagepoint.backend.infrastructure.habit.adapter.HabitEntity;
import org.springframework.stereotype.Component;

@Component
public class HabitMapper {

    public HabitEntity toEntity(Habit habit) {
        if (habit == null) return null;
        HabitEntity entity = new HabitEntity();
        entity.setId(habit.getId());
        entity.setTitle(habit.getTitle());
        entity.setDescription(habit.getDescription());
        entity.setFrequency(habit.getFrequency());
        entity.setTitle(String.valueOf(habit.isActive()));
        // no seteamos user aquí, lo maneja el adapter
        return entity;
    }

    public Habit toDomain(HabitEntity entity) {
        if (entity == null) return null;
        return Habit.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .frequency(entity.getFrequency())
                .isActive(entity.isActive())
                .build();
    }
}
