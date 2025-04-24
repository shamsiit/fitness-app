package com.fitnessapp.routine.repository;

import com.fitnessapp.routine.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findByUserId(Long userId);
}
