package com.techxion.fitness.service.impl;

import com.techxion.fitness.dto.response.BaseResponse;
import com.techxion.fitness.repository.UserRepository;
import com.techxion.fitness.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public BaseResponse listAllUserForAdmin() {

        List<com.techxion.fitness.entity.User> listOfUser = userRepository.findAll();
        BaseResponse listOfUserResponse = new BaseResponse();
        listOfUserResponse.setData(listOfUser);

        return listOfUserResponse;
    }
}
