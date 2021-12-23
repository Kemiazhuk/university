package com.kem.university.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger LOGGER = LogManager.getLogger(HomeController.class);

    @GetMapping("/student-page")
    public String showStudentPage() {
        LOGGER.info("Student come to home page");
        return "student-page";
    }

    @GetMapping("/teacher-page")
    public String showTeacherPage() {
        LOGGER.info("Teacher come to home page");
        return "teacher-page";
    }
}
