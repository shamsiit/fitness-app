package com.fitnessapp.analytics.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgressSummaryDto {
    private String exerciseName;
    private double highestWeight;
    private int maxReps;
    private double estimatedOneRepMax;
}
