package com.sparta.individualassignment.javaassignment_individual.controller;

import com.sparta.individualassignment.javaassignment_individual.dto.UserRequestDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.UserRoleEnum;
import com.sparta.individualassignment.javaassignment_individual.jwt.JwtUtil;
import com.sparta.individualassignment.javaassignment_individual.service.Userservice;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
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


    @GetMapping("/get-jwt")
    public String getJwt(@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue) {
        // JWT 토큰 substring
        String token = jwtUtil.substringToken(tokenValue);

        // 토큰 검증
        if (!jwtUtil.validateToken(token)) {
            throw new IllegalArgumentException("Token Error");
        }

        // 토큰에서 사용자 정보 가져오기
        Claims info = jwtUtil.getUserInfoFromToken(token);

        // 사용자 manager
        String manager = info.getSubject();
        System.out.println("username = " + manager);

        // 사용자 권한
        String authority = (String) info.get(JwtUtil.AUTHORIZATION_KEY);
        System.out.println("authority = " + authority);
        return "getJwt : " + manager + ", " + authority;
    }

    private final Userservice userservice;
    @GetMapping("/signup")
    public ResponseEntity<String> signupPage(@Valid @RequestBody UserRequestDto requestDto) {
        userservice.signup(requestDto);
        return new ResponseEntity<>("회원가입 성공했습니다.", HttpStatus.OK);
    }


}