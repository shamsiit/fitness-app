package com.fitnessapp.workout.service;

import com.fitnessapp.workout.dto.WorkoutDto;

import java.util.List;

public interface WorkoutService {
    WorkoutDto createWorkout(WorkoutDto dto);
    List<WorkoutDto> getWorkoutsByUser(Long userId);
}
