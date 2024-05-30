package com.sparta.individualassignment.javaassignment_individual.entitiy;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DB의 한 줄
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="scheduler")
public class Scheduler extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String manager;

    @Column(nullable = false)
    private String password;



    public Scheduler(SchedulerRequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();

    }

    public void update(SchedulerRequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
    }



}
