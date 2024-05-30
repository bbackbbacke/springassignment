package com.sparta.individualassignment.javaassignment_individual.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class SchedulerRequestDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private String password;
    private LocalDate date;


}
