package com.fitnessapp.service;

import com.fitnessapp.dto.RoutineDto;

import java.util.List;

public interface RoutineService {
    RoutineDto createRoutine(RoutineDto dto);
    List<RoutineDto> getUserRoutines(Long userId);
}
