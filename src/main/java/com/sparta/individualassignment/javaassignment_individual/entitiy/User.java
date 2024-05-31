package com.sparta.individualassignment.javaassignment_individual.entitiy;

import com.sparta.individualassignment.javaassignment_individual.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
@AllArgsConstructor

public class User extends TimestampedOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String authority;


    public User(UserRequestDto requestDto) {
        this.nickname = requestDto.getNickname();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.authority = requestDto.getAuthority();
    }

}
