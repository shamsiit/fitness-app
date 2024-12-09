package com.techxion.fitness.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "year_of_age")
    private int yearOfAge;
    @Column(name = "weight_in_kg")
    private double weightInKg;
    @Column(name = "height_in_cm")
    private double heightInCM;
    @Column(name = "profile_pic_path")
    private String profilePicPath;
    @OneToOne(mappedBy = "userProfile")
    private User user;
}
