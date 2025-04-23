package com.fitnessapp.exercise.repository;

import com.fitnessapp.exercise.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {}
