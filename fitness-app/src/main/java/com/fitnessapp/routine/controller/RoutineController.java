package com.fitnessapp.routine.controller;

import com.fitnessapp.routine.dto.RoutineDto;
import com.fitnessapp.routine.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routines")
@RequiredArgsConstructor
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping
    public ResponseEntity<RoutineDto> createRoutine(@RequestBody RoutineDto dto) {
        return ResponseEntity.ok(routineService.createRoutine(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RoutineDto>> getUserRoutines(@PathVariable Long userId) {
        return ResponseEntity.ok(routineService.getUserRoutines(userId));
    }
}
