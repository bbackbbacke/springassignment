package com.sparta.individualassignment.javaassignment_individual.service;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import com.sparta.individualassignment.javaassignment_individual.repository.SchedulerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerService(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    public SchedulerResponseDto createSchedule(SchedulerRequestDto requestDto) {
        // RequestDto -> Entity
        Scheduler scheduler = new Scheduler(requestDto);

        // DB 저장
        Scheduler saveScheduler = schedulerRepository.save(scheduler);

        // Entity -> ResponseDto
        SchedulerResponseDto schedulerResponseDto = new SchedulerResponseDto(scheduler);

        return schedulerResponseDto;
    }
    //한 개 조회
    public List<SchedulerResponseDto> getScheduler(Long id) {
        //scheduler -- >  schedulerResponseDto를 맞추기
       return schedulerRepository.findAllByIdOrderByCreatedAtDesc(id).stream().map(SchedulerResponseDto::new).toList();
    }
    //접근제어자 리턴타입 메서드이름 (파라미터) { 코드 }
    //흐름

    //전체 조회
    public List<SchedulerResponseDto> getSchedulers() {
        return schedulerRepository.findAllByOrderByCreatedAtDesc().stream().map(SchedulerResponseDto::new).toList();

    }

    //컨 -> 서 -> 레


    @Transactional
    public SchedulerResponseDto modifySchedule(Long id, SchedulerRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        // Exception orElseThrow 조건에 부합
        Scheduler scheduler = schedulerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 일정은 존재하지 않습니다."));
        // 일정 수정, 삭제 시 선택한 일정의 비밀번호와 요청할 때 함께 보낸 비밀번호가 일치할 경우에만 가능합니다.
        // 비밀번호는 2종류 1. 저장되어있는 비밀번호, 2. requestdto로부터 오는 비밀번호 => 두개가 같으면, ~ 뭐뭐다. 값은 어디있는지 생각해서!
        // scheduler가 null이 아니고, 패스워드가 같을 때 일정 수정을 한다.

        if (!scheduler.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다!");
        }

        scheduler.update(requestDto);
        return new SchedulerResponseDto(id, requestDto.getTitle(), requestDto.getContents(), requestDto.getManager(), scheduler.getCreatedAt());
    }

        @Transactional
        public Long deleteScheduler (Long id, SchedulerRequestDto requestDto){
            // 해당 메모가 DB에 존재하는지 확인
            Scheduler scheduler = schedulerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 일정은 존재하지 않습니다."));

            if (!scheduler.getPassword().equals(requestDto.getPassword())) {
                throw new IllegalArgumentException("비밀번호가 틀렸습니다!");
            }

            // db의 한 줄 = 일정 한 개 = scheduler 따라서 scheduler을 지워야 하는 것!
            schedulerRepository.delete(scheduler);
            return id;


        }

    }

