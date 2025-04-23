package com.fitnessapp.auth.service.impl;

import com.fitnessapp.auth.dto.AuthRequest;
import com.fitnessapp.auth.dto.AuthResponse;
import com.fitnessapp.auth.dto.RegisterRequest;
import com.fitnessapp.auth.model.Role;
import com.fitnessapp.auth.model.User;
import com.fitnessapp.auth.repository.UserRepository;
import com.fitnessapp.security.JwtUtil;
import com.fitnessapp.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        return new AuthResponse(jwtUtil.generateToken(user.getUsername()));
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        return new AuthResponse(jwtUtil.generateToken(request.getUsername()));
    }
}
