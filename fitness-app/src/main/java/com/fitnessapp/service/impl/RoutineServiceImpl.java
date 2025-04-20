package com.fitnessapp.service.impl;

import com.fitnessapp.dto.*;
import com.fitnessapp.model.*;
import com.fitnessapp.repository.*;
import com.fitnessapp.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository routineRepo;
    private final RoutineTemplateRepository templateRepo;
    private final WorkoutPlanRepository workoutPlanRepo;
    private final ExerciseRepository exerciseRepo;
    private final UserRepository userRepo;

    @Override
    public RoutineDto createRoutine(RoutineDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        RoutineTemplate template = dto.getTemplateId() != null ?
                templateRepo.findById(dto.getTemplateId()).orElse(null) : null;

        Routine routine = Routine.builder()
                .name(dto.getName())
                .user(user)
                .template(template)
                .build();

        final Routine savedRoutine = routineRepo.save(routine);

        List<WorkoutPlan> plans = dto.getWorkoutPlans().stream().map(planDto -> {
            Exercise exercise = exerciseRepo.findById(planDto.getExerciseId()).orElseThrow();
            return WorkoutPlan.builder()
                    .routine(savedRoutine)
                    .template(template)
                    .day(planDto.getDay())
                    .exercise(exercise)
                    .reps(planDto.getReps())
                    .weight(planDto.getWeight())
                    .restTime(planDto.getRestTime())
                    .build();
        }).collect(Collectors.toList());

        savedRoutine.setWorkoutPlans(workoutPlanRepo.saveAll(plans));
        return toDto(savedRoutine);
    }

    @Override
    public List<RoutineDto> getUserRoutines(Long userId) {
        return routineRepo.findByUserId(userId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private RoutineDto toDto(Routine routine) {
        List<WorkoutPlanDto> planDtos = routine.getWorkoutPlans().stream().map(plan ->
                WorkoutPlanDto.builder()
                        .id(plan.getId())
                        .day(plan.getDay())
                        .exerciseId(plan.getExercise().getId())
                        .reps(plan.getReps())
                        .weight(plan.getWeight())
                        .restTime(plan.getRestTime())
                        .build()
        ).collect(Collectors.toList());

        return RoutineDto.builder()
                .id(routine.getId())
                .name(routine.getName())
                .userId(routine.getUser().getId())
                .templateId(routine.getTemplate() != null ? routine.getTemplate().getId() : null)
                .workoutPlans(planDtos)
                .build();
    }
}
