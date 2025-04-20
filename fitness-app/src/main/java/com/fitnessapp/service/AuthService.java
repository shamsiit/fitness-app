package com.fitnessapp.service;

import com.fitnessapp.dto.*;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
}
