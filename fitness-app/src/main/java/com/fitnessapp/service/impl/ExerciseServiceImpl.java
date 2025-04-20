package com.fitnessapp.service.impl;

import com.fitnessapp.dto.ExerciseDto;
import com.fitnessapp.model.Exercise;
import com.fitnessapp.repository.ExerciseRepository;
import com.fitnessapp.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepo;

    @Override
    public ExerciseDto addExercise(ExerciseDto dto) {
        Exercise exercise = Exercise.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .build();
        Exercise saved = exerciseRepo.save(exercise);
        return ExerciseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .category(saved.getCategory())
                .build();
    }

    @Override
    public List<ExerciseDto> getAllExercises() {
        return exerciseRepo.findAll().stream()
                .map(e -> ExerciseDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .category(e.getCategory())
                        .build())
                .collect(Collectors.toList());
    }
}
