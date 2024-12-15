package com.techxion.fitness.controller;

import com.techxion.fitness.dto.request.SignUpRequest;
import com.techxion.fitness.dto.request.SigninRequest;
import com.techxion.fitness.dto.response.JwtAuthenticationResponse;
import com.techxion.fitness.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/create-admin-user")
    public ResponseEntity<JwtAuthenticationResponse> createAdminUser(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.createAdminUser(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}