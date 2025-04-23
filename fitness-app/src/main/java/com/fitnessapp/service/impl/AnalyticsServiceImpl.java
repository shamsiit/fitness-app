package com.fitnessapp.service.impl;

import com.fitnessapp.dto.AnalyticsReport;
import com.fitnessapp.workout.model.Workout;
import com.fitnessapp.workout.model.WorkoutSet;
import com.fitnessapp.workout.repository.WorkoutRepository;
import com.fitnessapp.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.*;

import static java.util.Locale.ENGLISH;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final WorkoutRepository workoutRepo;

    @Override
    public AnalyticsReport getAnalyticsForUser(Long userId) {
        List<Workout> workouts = workoutRepo.findByUserId(userId);

        int totalWorkouts = workouts.size();
        double totalVolume = 0.0;
        Map<String, Double> volumeByCategory = new HashMap<>();
        Map<String, Integer> workoutsPerDay = new HashMap<>();
        Map<String, Double> weeklyVolume = new HashMap<>();
        Map<String, Double> monthlyVolume = new HashMap<>();

        for (Workout workout : workouts) {
            String dayOfWeek = workout.getDate().getDayOfWeek().getDisplayName(TextStyle.FULL, ENGLISH);
            String month = workout.getDate().getMonth().getDisplayName(TextStyle.FULL, ENGLISH);

            workoutsPerDay.put(dayOfWeek, workoutsPerDay.getOrDefault(dayOfWeek, 0) + 1);

            for (WorkoutSet set : workout.getSets()) {
                double volume = set.getWeight() * set.getReps();
                totalVolume += volume;

                // Volume by category
                String category = set.getExercise().getCategory();
                volumeByCategory.put(category, volumeByCategory.getOrDefault(category, 0.0) + volume);

                // Weekly and monthly volume
                weeklyVolume.put(dayOfWeek, weeklyVolume.getOrDefault(dayOfWeek, 0.0) + volume);
                monthlyVolume.put(month, monthlyVolume.getOrDefault(month, 0.0) + volume);
            }
        }

        return AnalyticsReport.builder()
                .totalWorkouts(totalWorkouts)
                .totalVolume(totalVolume)
                .volumeByCategory(volumeByCategory)
                .workoutsPerDay(workoutsPerDay)
                .weeklyVolume(weeklyVolume)
                .monthlyVolume(monthlyVolume)
                .build();
    }
}
