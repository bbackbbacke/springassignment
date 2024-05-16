package com.sparta.individualassignment.javaassignment_individual.repository;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

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

    public List<SchedulerResponseDto> findAll() {
        //DB 조회
        String sql = "SELECT * FROM SCHEDULER";

        return jdbcTemplate.query(sql, new RowMapper<SchedulerResponseDto>() {
            @Override
            public SchedulerResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String contents = rs.getString("contents");
                String manager = rs.getString("manager");
                Long password = rs.getLong("password");
                LocalDate date = rs.getDate("date").toLocalDate();

                return new SchedulerResponseDto(title, contents, manager, password, date);
            }
        });
    }
}

