package edu.romoshi.diary.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "habit_t")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int frequency;

    private Long userId;

    @Column(updatable = false)
    private LocalDate registrationDate;

    @PrePersist
    protected void onCreate() {
        registrationDate = LocalDate.now();
    }
}
