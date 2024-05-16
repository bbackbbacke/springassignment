package com.sparta.individualassignment.javaassignment_individual.service;

import com.sparta.individualassignment.javaassignment_individual.controller.repository.SchedulerRepository;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;

public class SchedulerService {
    private final JdbcTemplate jdbcTemplate;

    public SchedulerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SchedulerResponseDto createSchedule(SchedulerRequestDto requestDto) {

        // RequestDto -> Entity
        Scheduler scheduler = new Scheduler(requestDto);

        // DB 저장
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        Scheduler saveScheduler = schedulerRepository.save(scheduler);


        // Entity -> ResponseDto
        SchedulerResponseDto schedulerResponseDto = new SchedulerResponseDto(scheduler);

        return schedulerResponseDto;
    }
}
