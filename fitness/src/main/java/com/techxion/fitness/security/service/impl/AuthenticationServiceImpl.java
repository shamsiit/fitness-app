package com.techxion.fitness.security.service.impl;

import com.techxion.fitness.dto.request.SignUpRequest;
import com.techxion.fitness.dto.request.SigninRequest;
import com.techxion.fitness.dto.response.JwtAuthenticationResponse;
import com.techxion.fitness.entity.SubscriptionStatus;
import com.techxion.fitness.entity.UserProfile;
import com.techxion.fitness.enums.Role;
import com.techxion.fitness.repository.UserProfileRepository;
import com.techxion.fitness.repository.UserRepository;
import com.techxion.fitness.entity.User;
import com.techxion.fitness.security.service.AuthenticationService;
import com.techxion.fitness.security.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    @Transactional
    public JwtAuthenticationResponse signup(SignUpRequest request) {

        var userProfile = UserProfile.builder().build();
        userProfileRepository.save(userProfile);

        var user = User.builder().username(request.getUserName())
                .email(request.getEmail())
                .subscriptionStatus(SubscriptionStatus.FREE)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .userProfile(userProfile)
                .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUserName())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}