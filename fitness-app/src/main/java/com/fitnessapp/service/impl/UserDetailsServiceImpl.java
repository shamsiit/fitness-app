package com.fitnessapp.service.impl;

import com.fitnessapp.repository.UserRepository;
import com.fitnessapp.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
