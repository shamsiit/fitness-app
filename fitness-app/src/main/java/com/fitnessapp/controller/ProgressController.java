package com.fitnessapp.controller;

import com.fitnessapp.dto.ProgressSummaryDto;
import com.fitnessapp.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class ProgressController {

    private final ProgressService progressService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProgressSummaryDto>> getUserProgress(@PathVariable Long userId) {
        return ResponseEntity.ok(progressService.getUserProgress(userId));
    }

    @GetMapping("/user/{userId}/exercise/{exerciseId}")
    public ResponseEntity<ProgressSummaryDto> getProgressByExercise(
            @PathVariable Long userId,
            @PathVariable Long exerciseId) {
        return ResponseEntity.ok(progressService.getUserProgressByExercise(userId, exerciseId));
    }
}
