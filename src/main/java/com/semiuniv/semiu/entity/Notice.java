package com.semiuniv.semiu.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Integer id;

    private String title;

    @Lob
    private String content;

    @Column(name = "created_time")
    private Timestamp createdTime;
}
