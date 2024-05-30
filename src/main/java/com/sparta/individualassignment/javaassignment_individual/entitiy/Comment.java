package com.sparta.individualassignment.javaassignment_individual.entitiy;

import com.sparta.individualassignment.javaassignment_individual.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor

public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Scheduler scheduler;


    public Comment(CommentRequestDto requestDto, Scheduler scheduler) {
        this.user_id = requestDto.getUser_id();
        this.comment = requestDto.getComment();
        this.scheduler = scheduler;
    }

}

