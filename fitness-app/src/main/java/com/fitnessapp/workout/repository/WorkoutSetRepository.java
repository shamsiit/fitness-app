package com.fitnessapp.workout.repository;

import com.fitnessapp.workout.model.WorkoutSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutSetRepository extends JpaRepository<WorkoutSet, Long> {}
