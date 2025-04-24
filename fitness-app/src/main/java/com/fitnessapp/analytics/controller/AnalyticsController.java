package com.fitnessapp.analytics.controller;

import com.fitnessapp.analytics.dto.AnalyticsReport;
import com.fitnessapp.analytics.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<AnalyticsReport> getUserAnalytics(@PathVariable Long userId) {
        return ResponseEntity.ok(analyticsService.getAnalyticsForUser(userId));
    }
}
