package com.fitnessapp.repository;

import com.fitnessapp.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {}
