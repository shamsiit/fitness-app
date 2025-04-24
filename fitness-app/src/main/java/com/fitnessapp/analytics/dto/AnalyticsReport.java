package com.fitnessapp.analytics.dto;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyticsReport {
    private int totalWorkouts;
    private double totalVolume;
    private Map<String, Double> volumeByCategory;
    private Map<String, Integer> workoutsPerDay;
    private Map<String, Double> weeklyVolume;
    private Map<String, Double> monthlyVolume;
}
