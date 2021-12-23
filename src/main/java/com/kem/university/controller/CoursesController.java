//package com.kem.university.controller;
//
//import com.kem.university.dto.Course;
//import com.kem.university.service.CourseService;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/courses")
//public class CoursesController {
//
//    private static final Logger LOGGER = LogManager.getLogger(CoursesController.class);
//    private final CourseService courseService;
//
//    @Autowired
//    public CoursesController(CourseService courseService) {
//        this.courseService = courseService;
//    }
//
//    @GetMapping("/all")
//    public String getAllCourses(Model model) {
//
//        List<Course> allCourses = courseService.getAllCourses();
//        model.addAttribute("allCourses", allCourses);
//        return "showCourses";
//    }
//
//    @GetMapping("/oneCourseInformation/{name}")
//    public String getCourseInformation(@PathVariable String name, Model model) {
//        Course course = courseService.findCourseByName(name);
//        model.addAttribute("course", course);
//        return "oneCourseInformation";
//    }
//
//    @PostMapping("/oneCourseInformation/{name}")
//    public String addCourseToStudent(@PathVariable String name, Model model) {
//        Course course = courseService.findCourseByName(name);
//        model.addAttribute("course", course);
//        return "oneCourseInformation";
//    }
//
//    @GetMapping("/name")
//    public String getCourseByName(@RequestParam String name,
//                                  Model model) {
//        Course course = courseService.findCourseByName(name);
//        List<Course> allCourses = new ArrayList<>();
//        allCourses.add(course);
//        model.addAttribute("allCourses", allCourses);
//        return "showCourses";
//    }
//
//    @GetMapping("/teacher")
//    public String getCourseByAuthor(@RequestParam String firstName,
//                                    @RequestParam String secondName,
//                                    Model model) {
//        List<Course> allCourses = courseService.findCourseByTeacher(firstName, secondName);
//        model.addAttribute("allCourses", allCourses);
//        return "showCourses";
//    }
//
////    @GetMapping("/date")
////    public String getCourseByDate(@RequestParam String start,
////                                  @RequestParam String end,
////                                  Model model) {
////        List<Course> allCourses = courseService.findCourseByDate(start, end);
////        model.addAttribute("allCourses", allCourses);
////        return "showCourses";
////    }
//}
