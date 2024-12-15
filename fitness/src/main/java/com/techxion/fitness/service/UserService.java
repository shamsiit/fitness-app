package com.techxion.fitness.service;

import com.techxion.fitness.dto.response.BaseResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    BaseResponse listAllUserForAdmin();
}