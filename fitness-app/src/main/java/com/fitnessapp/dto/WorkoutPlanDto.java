package com.fitnessapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutPlanDto {
    private Long id;
    private String day;
    private Long exerciseId;
    private int reps;
    private double weight;
    private int restTime;
}
