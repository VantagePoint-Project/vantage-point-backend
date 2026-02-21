package com.vantagepoint.backend.domain.port;

import com.vantagepoint.backend.domain.model.Habit;
import java.util.List;
import java.util.Optional;

public interface HabitRepositoryPort {

    Habit save(Habit habit);

    Optional<Habit> findById(Long id);

    List<Habit> findAllByUserId(Long userId);

    void deleteById(Long id);

    boolean existsById(Long id);
}