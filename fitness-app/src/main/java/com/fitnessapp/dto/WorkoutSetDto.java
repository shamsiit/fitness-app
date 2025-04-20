package com.fitnessapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutSetDto {
    private Long id;
    private Long exerciseId;
    private int reps;
    private double weight;
    private int restTime;
}
