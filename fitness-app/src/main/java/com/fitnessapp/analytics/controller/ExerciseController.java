package com.fitnessapp.analytics.controller;

import com.fitnessapp.exercise.dto.ExerciseDto;
import com.fitnessapp.exercise.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<ExerciseDto> addExercise(@RequestBody ExerciseDto dto) {
        return ResponseEntity.ok(exerciseService.addExercise(dto));
    }

    @GetMapping
    public ResponseEntity<List<ExerciseDto>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.getAllExercises());
    }
}
