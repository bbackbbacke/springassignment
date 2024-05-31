package com.sparta.individualassignment.javaassignment_individual.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimestampedOne {

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;

}