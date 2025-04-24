package com.fitnessapp.routine.repository;

import com.fitnessapp.routine.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {}
