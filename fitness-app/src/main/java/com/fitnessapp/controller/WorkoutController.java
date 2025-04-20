package com.fitnessapp.controller;

import com.fitnessapp.dto.WorkoutDto;
import com.fitnessapp.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<WorkoutDto> createWorkout(@RequestBody WorkoutDto dto) {
        return ResponseEntity.ok(workoutService.createWorkout(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutDto>> getWorkouts(@PathVariable Long userId) {
        return ResponseEntity.ok(workoutService.getWorkoutsByUser(userId));
    }
}
