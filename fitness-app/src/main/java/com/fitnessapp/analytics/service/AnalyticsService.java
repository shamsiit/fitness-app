package com.fitnessapp.analytics.service;

import com.fitnessapp.analytics.dto.AnalyticsReport;

public interface AnalyticsService {
    AnalyticsReport getAnalyticsForUser(Long userId);
}
