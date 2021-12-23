package com.kem.university.service;

import com.kem.university.dto.Course;
import com.kem.university.entity.CourseEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.repository.AccountRepository;
import com.kem.university.repository.CourseRepository;
import com.kem.university.repository.TeacherRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private static final Logger LOGGER = LogManager.getLogger(CourseService.class);
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final AccountService accountService;

    public CourseService(CourseRepository courseRepository,
                         TeacherRepository teacherRepository,
                         AccountService accountService) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.accountService = accountService;
    }

    public List<Course> findStudentCourseByUserName(String userName) {
        LOGGER.debug("Get all course by user name from DB");
        return courseRepository
                .findStudentCourseByUserName(userName)
                .stream()
                .map(this::convertDataToCourse)
                .collect(Collectors.toList());
    }

    public List<Course> findAvailableCourseForStudent(String userName) {
        LOGGER.debug("Get available course for student from DB");
        return courseRepository
                .findCoursesForStudent(userName)
                .stream()
                .map(this::convertDataToCourse)
                .collect(Collectors.toList());
    }

    public Course findCourseByName(String name) {
        LOGGER.debug("Get course by name from DB");
        return convertDataToCourse(courseRepository.findByCourseName(name));
    }

    public CourseEntity addNewCourse(Course course, String userName) {
        TeacherEntity teacherEntity = accountService.getTeacherEntityByUserName(userName);
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(UUID.randomUUID().toString());
        courseEntity.setCourseName(course.getCourseName());
        courseEntity.setStartDate(course.getStartDate());
        courseEntity.setEndDate(course.getEndDate());
        courseEntity.setTeacherId(teacherEntity.getId());
        courseEntity.setTeacherEntity(accountService.getTeacherEntityByUserName(userName));
        courseRepository.save(courseEntity);
        List<CourseEntity> c = courseRepository.findAllByTeacherId(teacherEntity.getId());
        return courseRepository.save(courseEntity);
    }

    public List<Course> findCourseByTeacher(String firstName, String secondName) {
        LOGGER.debug("Get all course by teacher full name from DB");
        TeacherEntity teacher = teacherRepository.findByFirstNameAndSecondName(firstName, secondName);
        return courseRepository.findAllByTeacherId(teacher.getId())
                .stream()
                .map(this::convertDataToCourse)
                .collect(Collectors.toList());
    }


//    public List<Course> findCourseByDate(String paramStartDate, String paramEndDate) {
//        LOGGER.debug("Get all");
//        Date startDate = Date.valueOf(paramStartDate);
//        Date endDate = Date.valueOf(paramEndDate);
//        return courseRepository.findAllByStartDateBetween(startDate, endDate)
//                .stream()
//                .map(this::convertDataToCourse)
//                .collect(Collectors.toList());
//    }

    public List<Course> getAllCourses() {
        LOGGER.debug("Get all courses from DB");
        return courseRepository.findAll()
                .stream()
                .map(this::convertDataToCourse)
                .collect(Collectors.toList());
    }

    public Course convertDataToCourse(CourseEntity courseEntity) {
        LOGGER.debug("Convert data to DTO Course");
        return new Course()
                .newBuilder()
                .setId(courseEntity.getId())
                .setCourseName(courseEntity.getCourseName())
                .setStartDate(courseEntity.getStartDate())
                .setEndDate(courseEntity.getEndDate())
                .setFirstTeacherName(courseEntity.getTeacherEntity().getFirstName())
                .setSecondTeacherName(courseEntity.getTeacherEntity().getSecondName())
                .build();
    }

}
