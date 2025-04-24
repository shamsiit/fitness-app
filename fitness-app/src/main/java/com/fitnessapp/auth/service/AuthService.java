package com.fitnessapp.auth.service;

import com.fitnessapp.auth.dto.AuthRequest;
import com.fitnessapp.auth.dto.AuthResponse;
import com.fitnessapp.auth.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
}
