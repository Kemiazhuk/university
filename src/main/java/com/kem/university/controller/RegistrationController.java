package com.kem.university.controller;

import com.kem.university.config.Role;
import com.kem.university.dto.Profile;
import com.kem.university.entity.AccountEntity;
import com.kem.university.entity.StudentEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.service.AccountService;
import com.kem.university.service.StudentService;
import com.kem.university.service.TeacherService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class);
    private final AccountService accountService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public RegistrationController(AccountService accountService, StudentService studentService, TeacherService teacherService) {
        this.accountService = accountService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public String registration(Model model) {
        LOGGER.info("Some user comes to registration page");
        model.addAttribute("registrationRequest", new AccountEntity());
        return "registration";
    }

    @PostMapping()
    public String addAccount(@ModelAttribute("profile") Profile profile) {
        LOGGER.info("User add new account");
        StudentEntity studentEntity = null;
        TeacherEntity teacherEntity = null;
        if (Role.valueOf(profile.getRole()).equals(Role.STUDENT)) {
            studentEntity = createStudentEntity(profile);
        } else {
            teacherEntity = teacherService.addTeacher(profile);
        }
        AccountEntity registerAccount =
                accountService.createAccount(profile, studentEntity, teacherEntity);
        if (registerAccount != null) {
            return "redirect:login";
        } else {
            return "error-page";
        }
    }

    private StudentEntity createStudentEntity(Profile profile) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID().toString());
        studentEntity.setFirstName(profile.getFirstName());
        studentEntity.setSecondName(profile.getSecondName());
        studentEntity.setEmail(profile.getEmail());
        return studentEntity;
    }
}
