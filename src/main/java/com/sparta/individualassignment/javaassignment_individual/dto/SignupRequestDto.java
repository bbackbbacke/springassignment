package com.sparta.individualassignment.javaassignment_individual.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String nickname;

    private String username;

    private String password;

    private String authority;
    private String adminToken;
    private String email;
    private boolean isAdmin;
}




