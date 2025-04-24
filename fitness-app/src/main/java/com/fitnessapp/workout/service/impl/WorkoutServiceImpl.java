package com.fitnessapp.workout.service.impl;

import com.fitnessapp.auth.model.User;
import com.fitnessapp.auth.repository.UserRepository;
import com.fitnessapp.exercise.model.Exercise;
import com.fitnessapp.exercise.repository.ExerciseRepository;
import com.fitnessapp.workout.dto.WorkoutDto;
import com.fitnessapp.workout.dto.WorkoutSetDto;
import com.fitnessapp.workout.service.WorkoutService;
import com.fitnessapp.workout.model.Workout;
import com.fitnessapp.workout.model.WorkoutSet;
import com.fitnessapp.workout.repository.WorkoutRepository;
import com.fitnessapp.workout.repository.WorkoutSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepo;
    private final WorkoutSetRepository workoutSetRepo;
    private final ExerciseRepository exerciseRepo;
    private final UserRepository userRepo;

    @Override
    public WorkoutDto createWorkout(WorkoutDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();

        Workout workout = Workout.builder()
                .name(dto.getName())
                .date(dto.getDate())
                .user(user)
                .build();

        // ✅ make workout effectively final for use in lambda
        final Workout savedWorkout = workoutRepo.save(workout);

        List<WorkoutSet> sets = dto.getSets().stream().map(setDto -> {
            Exercise exercise = exerciseRepo.findById(setDto.getExerciseId()).orElseThrow();
            return WorkoutSet.builder()
                    .workout(savedWorkout)
                    .exercise(exercise)
                    .reps(setDto.getReps())
                    .weight(setDto.getWeight())
                    .restTime(setDto.getRestTime())
                    .build();
        }).collect(Collectors.toList());

        savedWorkout.setSets(workoutSetRepo.saveAll(sets));
        return toDto(savedWorkout);
    }

    @Override
    public List<WorkoutDto> getWorkoutsByUser(Long userId) {
        return workoutRepo.findByUserId(userId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private WorkoutDto toDto(Workout workout) {
        List<WorkoutSetDto> setDtos = workout.getSets().stream().map(set -> WorkoutSetDto.builder()
                .id(set.getId())
                .exerciseId(set.getExercise().getId())
                .reps(set.getReps())
                .weight(set.getWeight())
                .restTime(set.getRestTime())
                .build()).collect(Collectors.toList());

        return WorkoutDto.builder()
                .id(workout.getId())
                .name(workout.getName())
                .date(workout.getDate())
                .userId(workout.getUser().getId())
                .sets(setDtos)
                .build();
    }
}
