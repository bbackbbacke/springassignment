package com.sparta.individualassignment.javaassignment_individual.controller;

import com.sparta.individualassignment.javaassignment_individual.entitiy.UserRoleEnum;
import com.sparta.individualassignment.javaassignment_individual.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final JwtUtil jwtUtil;

    @GetMapping("/create-jwt")
    public String createJwt(@RequestParam String manager, HttpServletResponse res) {
        // Jwt 생성
        String token = jwtUtil.createToken(manager, UserRoleEnum.USER);

        // Jwt 쿠키 저장
        jwtUtil.addJwtToCookie(token, res);

        return "createJwt : " + token;
    }












}