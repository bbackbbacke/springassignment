package com.sparta.individualassignment.javaassignment_individual.repository;

import com.sparta.individualassignment.javaassignment_individual.entitiy.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
