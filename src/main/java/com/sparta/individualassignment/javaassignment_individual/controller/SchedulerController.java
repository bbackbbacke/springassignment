package com.sparta.individualassignment.javaassignment_individual.controller;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.service.SchedulerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchedulerController {


    private final SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }


    //일정 작성
    @PostMapping("/schedules")
    public SchedulerResponseDto createSchedule(@RequestBody SchedulerRequestDto requestDto) {
        return schedulerService.createSchedule(requestDto);
    }


    //선택한 일정 조회
    @GetMapping("/schedules/{scheduler_id}")
    public List<SchedulerResponseDto> getScheduler(@PathVariable Long scheduler_id) {
        return schedulerService.getScheduler(scheduler_id);
    }

    //일정 목록 조회
    @GetMapping("/schedules")
    public List<SchedulerResponseDto> getSchedulers() {
        return schedulerService.getSchedulers();
    }


    //일정 수정
    @PutMapping("/schedules/{scheduler_id}")
    public SchedulerResponseDto modifySchedule(@PathVariable Long scheduler_id, @RequestBody SchedulerRequestDto requestDto) {
        return schedulerService.modifySchedule(scheduler_id, requestDto);
    }

    //
//
    //일정 삭제
    @DeleteMapping("/schedules/{scheduler_id}")
    public Long delete(@PathVariable Long scheduler_id, @RequestBody SchedulerRequestDto requestDto) {
        return schedulerService.deleteScheduler(scheduler_id, requestDto);

    }


}






