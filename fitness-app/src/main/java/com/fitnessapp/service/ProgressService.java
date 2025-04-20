package com.fitnessapp.service;

import com.fitnessapp.dto.ProgressSummaryDto;

import java.util.List;

public interface ProgressService {
    List<ProgressSummaryDto> getUserProgress(Long userId);
    ProgressSummaryDto getUserProgressByExercise(Long userId, Long exerciseId);
}
