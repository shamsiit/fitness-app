package com.fitnessapp.exercise.service;

import com.fitnessapp.exercise.dto.ExerciseDto;

import java.util.List;

public interface ExerciseService {
    ExerciseDto addExercise(ExerciseDto dto);
    List<ExerciseDto> getAllExercises();
}
