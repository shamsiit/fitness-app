package com.fitnessapp.service;

import com.fitnessapp.dto.ExerciseDto;

import java.util.List;

public interface ExerciseService {
    ExerciseDto addExercise(ExerciseDto dto);
    List<ExerciseDto> getAllExercises();
}
