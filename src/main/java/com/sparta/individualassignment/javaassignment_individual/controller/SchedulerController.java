package com.sparta.individualassignment.javaassignment_individual.controller;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.service.SchedulerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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



//    //선택한 일정 조회
//    @GetMapping("/viewselect")
//    public String viewselect() {
//        return "Schedule write";
//    }
//
//
//    //일정 목록 조회
//    @GetMapping("/viewlist")
//    public String viewlist() {
//        return "Schedule write";
//    }
//
//
//    //일정 수정
//    @PutMapping("/modify")
//    public String modify() {
//        return "Schedule write";
//    }
//
//
//    //일정 삭제
//    @DeleteMapping("/delete")
//    public String delete() {
//        return "Schedule write";
  }


    }

