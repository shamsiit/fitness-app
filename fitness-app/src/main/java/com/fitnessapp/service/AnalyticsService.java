package com.fitnessapp.service;

import com.fitnessapp.dto.AnalyticsReport;

public interface AnalyticsService {
    AnalyticsReport getAnalyticsForUser(Long userId);
}
