package com.semiuniv.semiu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data
public class StudentSubject {

    @Id
    @GeneratedValue
    @Column(name = "student_subject_id")
    private Integer id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
