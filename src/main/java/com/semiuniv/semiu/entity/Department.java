package com.semiuniv.semiu.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Integer id;

    @Column(name = "dept_name", length = 30, unique = true)
    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "college_id")
    private College college;
}
