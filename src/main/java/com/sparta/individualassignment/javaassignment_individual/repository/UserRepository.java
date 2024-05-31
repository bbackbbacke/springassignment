package com.sparta.individualassignment.javaassignment_individual.repository;

import com.sparta.individualassignment.javaassignment_individual.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
