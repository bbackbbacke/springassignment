package com.sparta.individualassignment.javaassignment_individual.controller.repository;

import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SchedulerRepository {
    private final JdbcTemplate jdbcTemplate;

    public SchedulerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Scheduler save(Scheduler scheduler) {
        //DB 저장
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO SCHEDULER (title, contents, manager, password, date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, scheduler.getTitle());
                    preparedStatement.setString(2, scheduler.getContents());
                    preparedStatement.setString(3, scheduler.getManager());
                    preparedStatement.setLong(4, scheduler.getPassword());
                    preparedStatement.setDate(5, Date.valueOf(scheduler.getDate()));
                    return preparedStatement;
                },
                keyHolder);

         //DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        scheduler.setId(id);

       return scheduler;
    }

}
