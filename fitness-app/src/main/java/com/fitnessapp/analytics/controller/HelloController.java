package com.fitnessapp.analytics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/protected")
    public String protectedHello() {
        return "✅ You have accessed a protected endpoint!";
    }
}
