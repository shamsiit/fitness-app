package com.fitnessapp.service.impl;

import com.fitnessapp.dto.ProgressSummaryDto;
import com.fitnessapp.model.Workout;
import com.fitnessapp.model.WorkoutSet;
import com.fitnessapp.repository.WorkoutRepository;
import com.fitnessapp.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    private final WorkoutRepository workoutRepo;

    @Override
    public List<ProgressSummaryDto> getUserProgress(Long userId) {
        List<Workout> workouts = workoutRepo.findByUserId(userId);
        Map<Long, ProgressSummaryDto> progressMap = new HashMap<>();

        for (Workout workout : workouts) {
            for (WorkoutSet set : workout.getSets()) {
                Long exerciseId = set.getExercise().getId();
                String exerciseName = set.getExercise().getName();
                double weight = set.getWeight();
                int reps = set.getReps();
                double oneRepMax = calculate1RM(weight, reps);

                ProgressSummaryDto current = progressMap.getOrDefault(exerciseId,
                        ProgressSummaryDto.builder()
                                .exerciseName(exerciseName)
                                .highestWeight(0)
                                .maxReps(0)
                                .estimatedOneRepMax(0)
                                .build());

                if (weight > current.getHighestWeight()) current.setHighestWeight(weight);
                if (reps > current.getMaxReps()) current.setMaxReps(reps);
                if (oneRepMax > current.getEstimatedOneRepMax()) current.setEstimatedOneRepMax(oneRepMax);

                progressMap.put(exerciseId, current);
            }
        }

        return new ArrayList<>(progressMap.values());
    }

    @Override
    public ProgressSummaryDto getUserProgressByExercise(Long userId, Long exerciseId) {
        List<Workout> workouts = workoutRepo.findByUserId(userId);

        double maxWeight = 0;
        int maxReps = 0;
        double max1RM = 0;
        String exerciseName = "";

        for (Workout workout : workouts) {
            for (WorkoutSet set : workout.getSets()) {
                if (Objects.equals(set.getExercise().getId(), exerciseId)) {
                    double weight = set.getWeight();
                    int reps = set.getReps();
                    double oneRepMax = calculate1RM(weight, reps);

                    maxWeight = Math.max(maxWeight, weight);
                    maxReps = Math.max(maxReps, reps);
                    max1RM = Math.max(max1RM, oneRepMax);
                    exerciseName = set.getExercise().getName();
                }
            }
        }

        return ProgressSummaryDto.builder()
                .exerciseName(exerciseName)
                .highestWeight(maxWeight)
                .maxReps(maxReps)
                .estimatedOneRepMax(max1RM)
                .build();
    }

    private double calculate1RM(double weight, int reps) {
        return reps == 1 ? weight : weight * (1 + (reps / 30.0)); // Epley formula
    }
}
