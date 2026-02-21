package com.vantagepoint.backend.infrastructure.habit.adapter.persistence;

import com.vantagepoint.backend.infrastructure.habit.adapter.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataHabitRepository extends JpaRepository<HabitEntity, Long> {

}

