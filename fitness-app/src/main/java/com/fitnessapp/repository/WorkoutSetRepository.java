package com.fitnessapp.repository;

import com.fitnessapp.model.WorkoutSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutSetRepository extends JpaRepository<WorkoutSet, Long> {}
