package com.techxion.fitness.controller;

import com.techxion.fitness.repository.UserRepository;
import com.techxion.fitness.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resource/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/get-for-admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> listUserForAdmin() {
        return ResponseEntity.ok(userService.listAllUserForAdmin());
    }
}