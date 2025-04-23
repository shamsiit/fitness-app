package com.fitnessapp.workout.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutDto {
    private Long id;
    private String name;
    private LocalDate date;
    private Long userId;
    private List<WorkoutSetDto> sets;
}
