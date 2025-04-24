package com.fitnessapp.analytics.service;

import com.fitnessapp.analytics.dto.ProgressSummaryDto;

import java.util.List;

public interface ProgressService {
    List<ProgressSummaryDto> getUserProgress(Long userId);
    ProgressSummaryDto getUserProgressByExercise(Long userId, Long exerciseId);
}
