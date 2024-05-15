package com.semiuniv.semiu.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Data
public class Classroom {

    @Id
    @Column(name = "classroom_id")
    private Integer id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "college_id")
    private College college;
}
