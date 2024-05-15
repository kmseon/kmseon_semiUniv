package com.semiuniv.semiu.controller;

import com.semiuniv.semiu.dto.*;
import com.semiuniv.semiu.entity.Student;
import com.semiuniv.semiu.entity.StudentSubject;
import com.semiuniv.semiu.entity.Subject;
import com.semiuniv.semiu.service.StudentService;
import com.semiuniv.semiu.service.StudentSubjectService;
import com.semiuniv.semiu.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/semi")
@RequiredArgsConstructor
public class ApplicationController {
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final StudentSubjectService studentSubjectService;

    //수강 신청 페이지 : 로그인 전
    @GetMapping("application")
    public String lectureApplicationView(Model model){
        //신청 과목
        List<Subject> subject = subjectService.showSubject();
        model.addAttribute("subject", subject);
        return "application/lectureApplication";
    }

    //수강 신청 페이지 : username로 이동 (조건 : 로그인 후)
    @GetMapping("application/{id}")
    public String lectureApplicationLoginView(@PathVariable("id") Integer id, Model model){
        //로그인한 학생 정보 : student
        Optional<Student> studentInfo = studentService.findById(id);
        Student studentLogin = studentInfo.get();
        model.addAttribute("studentLogin", studentLogin);
        System.out.printf("=============================");
        //수강신청 완료한 과목 제외
//        Optional<StudentSubject> applicationInfo = studentSubjectService.findAllById(id);
//        System.out.printf(applicationInfo.toString());
        //과목 목록 : subject
        List<Subject> subject = subjectService.showSubject();
        model.addAttribute("subject", subject);
        //학생이 신청한 과목 내역 new : studentSubject
        //! 관련 dto 삭제
        model.addAttribute("studentSubject", new StudentSubject());
        return "application/lectureApplication";
    }

    //수강 신청 페이지 : 수강 신청 내역 전송 ( 조건 : 로그인 한 학생 정보 데이터에 추가)
    @PostMapping("application/insert")
    public String test(@ModelAttribute("subject") Subject subject){
        //신청 과목 목록
        System.out.printf(subject.toString());

        return "application/lectureApplication";
    }

    //수강 신청 페이지 : 수강 신청 내역 전송 ( 조건 : 로그인 한 학생 정보 데이터에 추가)
    @PostMapping("application/insert/{id}")
    public String lectureApplicationInsert(@PathVariable("id") Student studentId,
                                           @RequestParam("checkedIds") Subject[] checkedIds,
                                           @ModelAttribute("studentSubject") StudentSubject studentSubject) {

        //studentSubject : subject : 해당 학생이 신청한 과목 내역 하나씩 추가
        for (Subject id : checkedIds){
            //studentSubject : student : 해당 학생 id 추가
            studentSubject.setStudent(studentId);
            studentSubject.setSubject(id);
            studentSubjectService.insertApplication(studentSubject);
        }

        return "redirect:/semi/application/{id}";
    }

    //수강 조회 페이지 : username로 이동 (조건 : 로그인 후)
    @GetMapping("application/show/{id}")
    public String lectureApplicationShow(@PathVariable("id") Integer id,
                                              Model model){
//        Optional<StudentSubject> applicationInfo = studentSubjectService.findAllById(id);
//        model.addAttribute("applicationInfo", applicationInfo);
//        System.out.printf("application"+applicationInfo.toString());
        return "application/showLectureApplication";
    }

}
