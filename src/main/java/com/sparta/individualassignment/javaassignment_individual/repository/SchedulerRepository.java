package com.sparta.individualassignment.javaassignment_individual.repository;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerResponseDto;
import com.sparta.individualassignment.javaassignment_individual.entitiy.Scheduler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

public class SchedulerRepository {
    private final JdbcTemplate jdbcTemplate;

    public SchedulerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Scheduler save(Scheduler scheduler) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO SCHEDULER (title, contents, manager, password, date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, scheduler.getTitle());
            preparedStatement.setString(2, scheduler.getContents());
            preparedStatement.setString(3, scheduler.getManager());
            preparedStatement.setLong(4, scheduler.getPassword());
            preparedStatement.setDate(5, Date.valueOf(scheduler.getDate()));
            return preparedStatement;
        }, keyHolder);
        Long id = keyHolder.getKey().longValue();
        scheduler.setId(id);
        return scheduler;
    }

    public List<SchedulerResponseDto> findAll() {
        String sql = "SELECT * FROM SCHEDULER";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new SchedulerResponseDto(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("contents"),
                rs.getString("manager"),
                rs.getLong("password"),
                rs.getDate("date").toLocalDate()
        ));
    }

    public void update(Long id, SchedulerRequestDto requestDto) {
        String sql = "UPDATE SCHEDULER SET title = ?, contents = ?, manager = ?, password = ?, date = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                requestDto.getTitle(), requestDto.getContents(), requestDto.getManager(), requestDto.getPassword(), Date.valueOf(requestDto.getDate()), id);
    }

    public Scheduler findById(Long id) {
        String sql = "SELECT * FROM SCHEDULER WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Scheduler scheduler = new Scheduler();
            scheduler.setId(rs.getLong("id"));
            scheduler.setTitle(rs.getString("title"));
            scheduler.setContents(rs.getString("contents"));
            scheduler.setManager(rs.getString("manager"));
            scheduler.setPassword(rs.getLong("password"));
            scheduler.setDate(rs.getDate("date").toLocalDate());
            return scheduler;
        });
    }
}
