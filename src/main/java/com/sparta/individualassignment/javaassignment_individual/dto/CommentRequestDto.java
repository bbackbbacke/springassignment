package com.sparta.individualassignment.javaassignment_individual.dto;


import lombok.Getter;

@Getter
public class CommentRequestDto {

    private Long user_id;
    private String comment;
    private Long schedule_id;


}
