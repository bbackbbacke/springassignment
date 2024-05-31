package com.sparta.individualassignment.javaassignment_individual.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String nickname;

    @Pattern(regexp="^[0-9a-z]{4,10}$") //커스텀패턴 어노테이션
    private String username;

    @Pattern(regexp="^[0-9a-zA-Z]{8,15}$") //커스텀패턴 어노테이션
    private String password;

    private String authority;


}
