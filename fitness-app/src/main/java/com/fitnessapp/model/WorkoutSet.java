package com.fitnessapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int reps;
    private double weight;
    private int restTime;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
}
