package com.semiuniv.semiu.dto;

import com.semiuniv.semiu.entity.Student;
import com.semiuniv.semiu.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectDto {

    private Integer id;

    private Student student;

    private Subject subject;

    public StudentSubjectDto(Student student) {
    }

}
