package com.techxion.fitness.security.service;


import com.techxion.fitness.dto.request.SignUpRequest;
import com.techxion.fitness.dto.request.SigninRequest;
import com.techxion.fitness.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse createAdminUser(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
