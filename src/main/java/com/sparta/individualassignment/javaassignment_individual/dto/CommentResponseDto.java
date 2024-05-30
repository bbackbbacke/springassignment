package com.sparta.individualassignment.javaassignment_individual.dto;

import com.sparta.individualassignment.javaassignment_individual.entitiy.Comment;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CommentResponseDto {
    private Long id;
    private Long user_id;
    private String comment;
    private Long schedule_id;


    public CommentResponseDto(Comment comment, Scheduler scheduler) {
        this.id = comment.getId();
        this.user_id = comment.getUser_id();
        this.comment = comment.getComment();
        this.schedule_id = scheduler.getId();
    }
}
