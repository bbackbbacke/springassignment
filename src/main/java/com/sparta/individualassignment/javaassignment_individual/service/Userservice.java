package com.sparta.individualassignment.javaassignment_individual.service;

import com.sparta.individualassignment.javaassignment_individual.dto.UserRequestDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.User;
import com.sparta.individualassignment.javaassignment_individual.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Userservice {
    private final UserRepository userRepository;

    public void signup(UserRequestDto requestDto) {
        userRepository.save(new User(requestDto));

    }
}
