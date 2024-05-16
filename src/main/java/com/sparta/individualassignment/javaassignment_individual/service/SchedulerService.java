package com.sparta.individualassignment.javaassignment_individual.service;

import com.sparta.individualassignment.javaassignment_individual.repository.SchedulerRepository;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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

    public List<SchedulerResponseDto> getSchedulers() {
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        return schedulerRepository.findAll();
    }

    public Long modifyScheduler(Long id, SchedulerRequestDto requestDto) {
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        // 해당 메모가 DB에 존재하는지 확인
        Scheduler scheduler = schedulerRepository.findById(id);
        if (scheduler != null) {
            // memo 내용 수정
            schedulerRepository.update(id, requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    public SchedulerResponseDto modifySchedule(Long id, SchedulerRequestDto requestDto) {
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        // 해당 메모가 DB에 존재하는지 확인
       Scheduler scheduler = schedulerRepository.findById(id);
        if (scheduler != null) {
            // memo 내용 수정
            schedulerRepository.update(id, requestDto);
            return new SchedulerResponseDto(id, requestDto.getTitle(), requestDto.getContents(), requestDto.getManager(), requestDto.getPassword(), requestDto.getDate());
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
}
