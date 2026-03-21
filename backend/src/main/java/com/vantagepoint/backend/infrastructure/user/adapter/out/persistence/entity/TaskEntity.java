package com.vantagepoint.backend.infrastructure.user.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class TaskEntity {

    @Id
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private String status;

    @Column(name = "due_date")
    private LocalDateTime dueDate;
}

