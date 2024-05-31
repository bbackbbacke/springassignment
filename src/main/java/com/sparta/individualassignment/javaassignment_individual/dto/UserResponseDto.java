package com.sparta.individualassignment.javaassignment_individual.dto;

import com.sparta.individualassignment.javaassignment_individual.entitiy.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String nickname;
    private String username;
    //    private String password;
    private String authority;
    private Timestamp date;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.username = user.getUsername();
    //      this.password = user.getPassword();
        this.authority = user.getAuthority();
        this.date = user.getDate();
    }
}
