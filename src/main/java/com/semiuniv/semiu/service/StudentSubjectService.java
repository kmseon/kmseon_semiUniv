package com.semiuniv.semiu.service;

import com.semiuniv.semiu.dto.ProfessorDto;
import com.semiuniv.semiu.dto.StudentSubjectDto;
import com.semiuniv.semiu.entity.Professor;
import com.semiuniv.semiu.entity.StudentSubject;
import com.semiuniv.semiu.repository.StudentSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentSubjectService {
    private final StudentSubjectRepository studentSubjectRepository;

    public void insertApplication(StudentSubject studentSubject) {
        studentSubjectRepository.save(studentSubject);
    }


    public Optional<StudentSubject> findAllById(Integer id) {
        //id = sudentId | studentSubject = studentId
        System.out.printf(String.valueOf(id));
        StudentSubject studentSubjectList = studentSubjectRepository.findByStudent_id(id);
        System.out.printf(studentSubjectList.toString());


        return studentSubjectRepository.findById(id);
    }
}
