package com.fitnessapp.model;

import com.fitnessapp.exercise.model.Exercise;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "routine_day")
    private String day; // e.g., "Monday", "Day 1", or "Upper Body"

    private int reps;
    private double weight;
    private int restTime;

    @ManyToOne
    private Exercise exercise;

    @ManyToOne
    private Routine routine;

    @ManyToOne
    private RoutineTemplate template;
}
