package com.sparta.individualassignment.javaassignment_individual.dto;

import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SchedulerResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
//    private Long password;
    private LocalDate date;

    public SchedulerResponseDto(Scheduler scheduler){
        this.id = scheduler.getId();
        this.title = scheduler.getTitle();
        this.contents = scheduler.getContents();
        this.manager = scheduler.getManager();
//        this.password = scheduler.getPassword();
        this.date = scheduler.getDate();
    }

    public SchedulerResponseDto(Long id, String title, String contents, String manager, LocalDate date){
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.manager = manager;
//        this.password = password;
        this.date = date;
    }
}




