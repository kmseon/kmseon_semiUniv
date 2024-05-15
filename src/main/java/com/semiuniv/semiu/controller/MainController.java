package com.semiuniv.semiu.controller;

import com.semiuniv.semiu.dto.NoticeDto;
import com.semiuniv.semiu.entity.Admin;
import com.semiuniv.semiu.entity.Professor;
import com.semiuniv.semiu.entity.Student;
import com.semiuniv.semiu.entity.Users;
import com.semiuniv.semiu.repository.UserRepository;
import com.semiuniv.semiu.service.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
//로그인 페이지로 이동이 안되서 RequestMapping을 위로 올림 +
@RequestMapping("/semi")
public class MainController {

    private final StudentService studentService;
    private final ProfessorService professorService;
    private final AdminService adminService;

    private final NoticeService noticeService;

    private final UserRepository userRepository;

    public MainController(StudentService studentService, ProfessorService professorService, AdminService adminService, NoticeService noticeService, UserRepository userRepository) {
        this.studentService = studentService;
        this.professorService = professorService;
        this.adminService = adminService;
        this.noticeService = noticeService;
        this.userRepository = userRepository;
    }

    @GetMapping("")
    //RequestMapping 주소 : localhost:8080/semi(main) +
    public String index(Model model) {
        //공지사항
        List<NoticeDto> noticeDto = noticeService.findAllNoticeMain();
        model.addAttribute("noticeDto", noticeDto);
        System.out.printf(noticeDto.toString());
        return "index";
    }

    // .defaultSuccessUrl : 로그인 성공 시 GetUrl > main.html
    // :로그인 후 다시 main:Index 페이지에 돌아왔을 때 로그인 정보와 같은 학생 정보 가져오기 +
    @GetMapping("login")
    public String login(Principal principal, Model model){
        Integer loginId = Integer.valueOf(principal.getName());
        System.out.printf("loginId" + loginId);
//        Users users = (Users) userDetailService.loadUserByUsername(String.valueOf(loginId));
        //로그인 한 User 정보 : Role 포함
        Optional<Users> users = userRepository.findById(loginId);
        System.out.printf("users" + users);

        //student
        Optional<Student> student = studentService.show_student(loginId);

        if(student.isEmpty()) {

            //professor
            Optional<Professor> professor = professorService.show_student(loginId);

            if(professor.isEmpty()){
                //admin
                Optional<Admin> admin = adminService.show_student(loginId);
                Admin adminLogin = admin.get();
                System.out.println(adminLogin.toString());
                model.addAttribute("adminLogin", adminLogin);

            }else{
                //professor
                Professor professorLogin = professor.get();
                System.out.println(professorLogin.toString());
                model.addAttribute("professorLogin", professorLogin);
            }
        } else {
            //student
            Student studentLogin = student.get();
            System.out.println(studentLogin.toString());
            model.addAttribute("studentLogin", studentLogin);

        }

        model.addAttribute("users", users);

        //공지사항
        List<NoticeDto> noticeDto = noticeService.findAllNoticeMain();
        model.addAttribute("noticeDto", noticeDto);

        return "index";
    }

    @GetMapping("/main")
    //RequestMapping 주소 : localhost:8080/semi(main) +
    public String main() {
        return "main";
    }
}
