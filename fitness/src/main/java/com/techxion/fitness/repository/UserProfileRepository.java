package com.techxion.fitness.repository;


import com.techxion.fitness.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}