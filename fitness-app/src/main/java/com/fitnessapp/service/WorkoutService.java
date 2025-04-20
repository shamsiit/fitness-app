package com.fitnessapp.service;

import com.fitnessapp.dto.WorkoutDto;

import java.util.List;

public interface WorkoutService {
    WorkoutDto createWorkout(WorkoutDto dto);
    List<WorkoutDto> getWorkoutsByUser(Long userId);
}
