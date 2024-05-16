package com.sparta.individualassignment.javaassignment_individual.controller;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.service.SchedulerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {


    private final JdbcTemplate jdbcTemplate;

    public SchedulerController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //일정 작성
    @PostMapping("/createSchedule")
    public SchedulerResponseDto createSchedule(@RequestBody SchedulerRequestDto requestDto) {
        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
        return schedulerService.createSchedule(requestDto);
    }


//    //선택한 일정 조회
//    @GetMapping("/selectedSchedule")
//    public SchedulerResponseDto getSchedulers() {
//        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
//        return schedulerService.getSchedulers();

    //
//
    //일정 목록 조회
    @GetMapping("/inquireAllList")
    public List<SchedulerResponseDto> getMemos() {
        SchedulerService memoService = new SchedulerService((jdbcTemplate));
        return memoService.getSchedulers();
    }


    //일정 수정
    @PutMapping("/modifySchedule/{id}")
    public SchedulerResponseDto modifySchedule(@PathVariable Long id,  @RequestBody SchedulerRequestDto requestDto) {
        SchedulerService memoService = new SchedulerService((jdbcTemplate));
        return memoService.modifySchedule(id, requestDto);
    }
//
//
//    //일정 삭제
//    @DeleteMapping("/delete")
//    public String delete() {
//        return "Schedule write";


}






