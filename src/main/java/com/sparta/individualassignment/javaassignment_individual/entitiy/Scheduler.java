package com.sparta.individualassignment.javaassignment_individual.entitiy;

import com.sparta.individualassignment.javaassignment_individual.dto.SchedulerRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Scheduler {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private Long password;
    private LocalDate date;

    public Scheduler(SchedulerRequestDto requestDto) {
        this.id = requestDto.getId();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
        this.date = LocalDate.now();
    }


//import com.sparta.memo.dto.MemoRequestDto;


//    @Getter
//    @Setter
//    @NoArgsConstructor
//    public class Memo {
//        private Long id;
//        private String username;
//        private String contents;
//
//        public Memo(MemoRequestDto requestDto) {
//            this.username = requestDto.getUsername();
//            this.contents = requestDto.getContents();
//        }
//
//        public void update(MemoRequestDto requestDto) {
//            this.username = requestDto.getUsername();
//            this.contents = requestDto.getContents();
//        }
//    }
}
