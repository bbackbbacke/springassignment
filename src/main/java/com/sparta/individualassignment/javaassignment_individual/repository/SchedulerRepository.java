package com.sparta.individualassignment.javaassignment_individual.repository;

import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {


    // 전체 조회
    List<Scheduler> findAllByOrderByCreatedAtDesc();

    // 하나 조회
    List<Scheduler> findAllByIdOrderByCreatedAtDesc(Long id); // 파라미터 넣는 공간이 where! 그래서 Robbie가 쓴 메모를 모아넣고 싶으면 (String Robbie) 하면 됨



}


