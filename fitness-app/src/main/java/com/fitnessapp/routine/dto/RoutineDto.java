package com.fitnessapp.routine.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutineDto {
    private Long id;
    private String name;
    private Long userId;
    private Long templateId;
    private List<WorkoutPlanDto> workoutPlans;
}
