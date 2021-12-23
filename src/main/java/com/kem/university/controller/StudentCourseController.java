package com.kem.university.controller;

import com.kem.university.dto.Course;
import com.kem.university.dto.Profile;
import com.kem.university.service.AccountService;
import com.kem.university.service.CourseService;
import com.kem.university.service.JournalService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student-page")
public class StudentCourseController {

    private static final Logger LOGGER = LogManager.getLogger(StudentCourseController.class);
    private final CourseService courseService;
    private final JournalService journalService;
    private final AccountService accountService;

    public StudentCourseController(CourseService courseService, JournalService journalService, AccountService accountService) {
        this.courseService = courseService;
        this.journalService = journalService;
        this.accountService = accountService;
    }


    @GetMapping("/courses/add")
    public String showAvailableCourses(Authentication auth, Model model) {
        LOGGER.info("Student see available course for him");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        List<Course> courseList = courseService.findAvailableCourseForStudent(userDetails.getUsername());
        model.addAttribute("allCourses", courseList);
        return "show-courses";
    }

    @PostMapping("/courses/add/save")
    public String addNewCourse(@RequestBody String body,
                               Authentication auth) {
        LOGGER.info("Student add course");
        List<String> idCourses = Arrays.asList(body.replaceAll("course=", "").split("&"));
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        journalService.addNewCourseInJournalForStudent(idCourses, userDetails.getUsername());
        return "student-page";
    }

    @GetMapping(value = {"/back", "*/back"})
    public String backToStudentPage() {
        LOGGER.info("Student click button 'back'");
        return "student-page";
    }

    @GetMapping("/courses/mine")
    public String showStudentCourses(Authentication auth, Model model) {
        LOGGER.info("Student see his courses");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        List<Course> courseList = courseService.findStudentCourseByUserName(userDetails.getUsername());
        model.addAttribute("allCourses", courseList);
        return "student-course";
    }

    @GetMapping("/profile")
    public String showStudentProfile(Authentication auth,
                                  Model model) {
        LOGGER.info("Student see his profile");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Profile profile = accountService.getInformationAboutAccount(userDetails.getUsername());
        if (profile != null ){
            model.addAttribute("user", profile);
            return "profile";
        } else{
            return "error-page";
        }
    }

    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute("profile") Profile profile,
                              Authentication auth) {
        LOGGER.info("Student edit his profile");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        accountService.updateDataStudentToAccount(profile, userDetails.getUsername());
        return "student-page";
    }

}
