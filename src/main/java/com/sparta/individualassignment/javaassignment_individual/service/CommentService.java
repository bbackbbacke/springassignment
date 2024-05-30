package com.sparta.individualassignment.javaassignment_individual.service;

import com.sparta.individualassignment.javaassignment_individual.dto.CommentRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.CommentResponseDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Comment;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import com.sparta.individualassignment.javaassignment_individual.repository.CommentRepository;
import com.sparta.individualassignment.javaassignment_individual.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //객체 자동 생
public class CommentService {

    private final CommentRepository commentRepository;
    private final SchedulerRepository schedulerRepository;



    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        Scheduler scheduler = schedulerRepository.findById(requestDto.getSchedule_id()).orElseThrow(()
                        -> new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
                );

        Comment comment = commentRepository.save(new Comment(requestDto, scheduler));
        return new CommentResponseDto(comment, scheduler);
    }


    public CommentResponseDto modifyComment(Long commentId, CommentRequestDto requestDto) {
        Scheduler scheduler = schedulerRepository.findById(requestDto.getSchedule_id()).orElseThrow(()
                -> new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );

        Comment comment = commentRepository.findById(commentId).orElseThrow(()
                -> new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );

        comment.update(requestDto);
        return new CommentResponseDto(comment, scheduler);
    }





}
