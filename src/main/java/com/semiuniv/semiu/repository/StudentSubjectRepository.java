package com.semiuniv.semiu.repository;

import com.semiuniv.semiu.entity.Student;
import com.semiuniv.semiu.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
//    @Query(value = "SELECT student_subject_id FROM student_subject WHERE id = student_id", nativeQuery = true)
//    List<Integer> findAllIds(Integer id);
    public StudentSubject findByStudent_id(Integer id);
}
