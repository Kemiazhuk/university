package com.kem.university.controller;

import com.kem.university.dto.Account;
import com.kem.university.dto.Course;
import com.kem.university.dto.JournalCourses;
import com.kem.university.dto.Profile;
import com.kem.university.service.AccountService;
import com.kem.university.service.CourseService;
import com.kem.university.service.JournalService;
import com.kem.university.service.TeacherService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/teacher-page")
public class TeacherController {

    private static final Logger LOGGER = LogManager.getLogger(TeacherController.class);
    private final TeacherService teacherService;
    private final AccountService accountService;
    private final JournalService journalService;
    private final CourseService courseService;

    public TeacherController(TeacherService teacherService,
                             AccountService accountService,
                             JournalService journalService,
                             CourseService courseService) {
        this.teacherService = teacherService;
        this.accountService = accountService;
        this.journalService = journalService;
        this.courseService = courseService;
    }

    @GetMapping("/profile")
    public String showUserProfile(Authentication auth,
                                  Model model) {
        LOGGER.info("Teacher check his profile");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Profile profile = accountService.getInformationAboutAccount(userDetails.getUsername());
        if (profile != null) {
            model.addAttribute("user", profile);
            return "profile";
        } else {
            return "error-page";
        }
    }

    @PostMapping("/profile/edit")
    public String editProfile(@ModelAttribute("profile") Profile profile,
                              Authentication auth) {
        LOGGER.info("Teacher edit his profile");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        accountService.updateDataTeacherToAccount(profile, userDetails.getUsername());
        return "teacher-page";
    }

    @GetMapping("/courses")
    public String getTeacherCourses(Model model, Authentication auth) {
        LOGGER.info("Teacher check his courses");
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        teacherService.getTeacherCourses(userDetails.getUsername());
        model.addAttribute("allCourses", teacherService.getTeacherCourses(userDetails.getUsername()));
        return "teacher-courses";
    }

    @GetMapping("/journalCourse")
    public String getJournalCourse(@PathParam("id") String id, Model model) {
        LOGGER.info("Teacher check his journal by one course");
        model.addAttribute("journal", journalService.getJournalByIdCourse(id));
        return "journal";
    }

    @GetMapping(value = {"/back", "*/back"})
    public String backToTeacherPage() {
        LOGGER.info("Teacher click button 'back'");
        return "teacher-page";
    }

    @PostMapping("/editJournal")
    public String editJournal(@PathParam("id") String id, Model model) {
        LOGGER.info("Teacher edit journal course");
        model.addAttribute("journal", journalService.getJournalById(id));
        return "edit-journal";
    }

    @PostMapping("/editJournal/save")
    public String editJournal(@PathParam("id") String id,
                              @ModelAttribute("journalCourse") JournalCourses journalCourse) {
        LOGGER.info("Teacher save his update in journal");
        journalService.editJournalCourse(id, journalCourse.getMark(), journalCourse.getReview());
        return "teacher-page";
    }

    @GetMapping("course/add")
    public String pageForNewCourse() {
        return "add-course";
    }

    @PostMapping("course/add/save")
    public String addNewCourse(@ModelAttribute Course course,
                               Authentication auth) {
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        if (courseService.addNewCourse(course, userDetails.getUsername()) != null) {
            return "teacher-page";
        } else {
            return "error-page";
        }
    }
}
