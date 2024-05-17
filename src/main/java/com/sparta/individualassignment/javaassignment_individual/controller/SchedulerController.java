package com.sparta.individualassignment.javaassignment_individual.controller;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.service.SchedulerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchedulerController {


    private final JdbcTemplate jdbcTemplate;

    public SchedulerController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //일정 작성
    @PostMapping("/schedules")
    public SchedulerResponseDto createSchedule(@RequestBody SchedulerRequestDto requestDto) {
        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
        return schedulerService.createSchedule(requestDto);
    }


//    //선택한 일정 조회
//    @GetMapping("/schedules")
//    public SchedulerResponseDto getSchedulers() {
//        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
//        return schedulerService.getSchedulers();

    //
//
    //일정 목록 조회
    @GetMapping("/schedules")
    public List<SchedulerResponseDto> getSchedulers() {
        SchedulerService schedulerService = new SchedulerService((jdbcTemplate));
        return schedulerService.getSchedulers();
    }


    //일정 수정
    @PutMapping("/schedules/{id}")
    public SchedulerResponseDto modifySchedule(@PathVariable Long id, @RequestBody SchedulerRequestDto requestDto) {
        SchedulerService schedulerService = new SchedulerService((jdbcTemplate));
        return schedulerService.modifySchedule(id, requestDto);
    }

    //
//
    //일정 삭제
    @DeleteMapping("/schedules/{id}")
    public Long delete(@PathVariable Long id) {
        SchedulerService schedulerService = new SchedulerService((jdbcTemplate));
        Long l = schedulerService.deleteScheduler(id);
        return l;
    }

}






