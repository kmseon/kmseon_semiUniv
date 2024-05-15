package com.semiuniv.semiu.service;

import com.semiuniv.semiu.dto.AdminDto;
import com.semiuniv.semiu.entity.Admin;
import com.semiuniv.semiu.entity.Professor;
import com.semiuniv.semiu.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    //등록
    public void insertAdmin(AdminDto dto) {
        Admin admin = AdminDto.toAdminEntity(dto);
        adminRepository.save(admin);
    }

    //조회
    public List<AdminDto> showAllAdmins() {
        List<AdminDto> adminDtoList = new ArrayList<>();
        return adminRepository.findAll()
                .stream()
                .map(AdminDto::fromAdminEntity)
                .toList();
    }

    public AdminDto showOneAdmin(Integer id) {
        return adminRepository.findById(id)
                .map(AdminDto::fromAdminEntity)
                .orElse(null);
    }

    //수정
    public void updateAdmin(AdminDto dto) {
        Admin admin = AdminDto.toAdminEntity(dto);
        adminRepository.save(admin);
    }

    //삭제
    public void deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
    }

    //로그인 후 학생 정보 : main.html +
    public Optional<Admin> show_student(Integer loginId) {
        return adminRepository.findById(loginId);
    }

}
