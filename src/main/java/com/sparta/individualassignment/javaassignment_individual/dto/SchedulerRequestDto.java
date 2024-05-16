package com.sparta.individualassignment.javaassignment_individual.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SchedulerRequestDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private Long password;
    private LocalDate date;
}
