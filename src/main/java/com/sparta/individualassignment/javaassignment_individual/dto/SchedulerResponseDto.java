package com.sparta.individualassignment.javaassignment_individual.dto;

import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulerResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
//    private String password;
    private LocalDateTime createdAt;

    public SchedulerResponseDto(Scheduler scheduler){
        this.id = scheduler.getId();
        this.title = scheduler.getTitle();
        this.contents = scheduler.getContents();
        this.manager = scheduler.getManager();
//        this.password = scheduler.getPassword();
        this.createdAt = scheduler.getCreatedAt();
    }

    public SchedulerResponseDto(Long id, String title, String contents, String manager, LocalDateTime createdAt){
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.manager = manager;
//        this.password = password;
        this.createdAt = createdAt;
    }
}




