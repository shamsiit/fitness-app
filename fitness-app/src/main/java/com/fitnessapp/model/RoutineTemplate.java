package com.fitnessapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutineTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // "Push-Pull-Legs", "Full Body Strength"

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutPlan> workoutPlans;
}
