package com.fitnessapp.routine.service;

import com.fitnessapp.routine.dto.RoutineDto;

import java.util.List;

public interface RoutineService {
    RoutineDto createRoutine(RoutineDto dto);
    List<RoutineDto> getUserRoutines(Long userId);
}
