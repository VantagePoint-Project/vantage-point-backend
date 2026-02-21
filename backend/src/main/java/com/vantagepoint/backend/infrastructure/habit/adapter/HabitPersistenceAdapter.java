package com.vantagepoint.backend.infrastructure.habit.adapter;

import com.vantagepoint.backend.domain.model.Habit;
import com.vantagepoint.backend.domain.port.HabitRepositoryPort;

import java.util.List;
import java.util.Optional;

public class HabitPersistenceAdapter implements HabitRepositoryPort {

    @Override
    public Habit save(Habit habit) {
        return null;
    }

    @Override
    public Optional<Habit> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Habit> findAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
