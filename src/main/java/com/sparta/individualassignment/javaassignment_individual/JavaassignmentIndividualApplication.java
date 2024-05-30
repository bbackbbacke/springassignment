package com.sparta.individualassignment.javaassignment_individual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavaassignmentIndividualApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaassignmentIndividualApplication.class, args);
    }

}
