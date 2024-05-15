package com.semiuniv.semiu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "college_id")
    private Integer id;

    @Column(name = "college_name", length = 30, unique = true)
    private String name;
}
