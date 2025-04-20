package com.fitnessapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseDto {
    private Long id;
    private String name;
    private String category;
}
