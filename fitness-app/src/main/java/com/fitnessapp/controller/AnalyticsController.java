package com.fitnessapp.controller;

import com.fitnessapp.dto.AnalyticsReport;
import com.fitnessapp.service.AnalyticsService;
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
