package com.kem.university;

import com.kem.university.dto.Course;
import com.kem.university.entity.CourseEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.repository.CourseRepository;
import com.kem.university.repository.TeacherRepository;
import com.kem.university.service.AccountService;
import com.kem.university.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CourseServiceTest {

    private CourseService courseService;
    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;
    private AccountService accountService;

    private final String id = "1l";

    @BeforeEach
    void setUp() {
        courseRepository = Mockito.mock(CourseRepository.class);
        accountService = Mockito.mock(AccountService.class);
        courseService = new CourseService(courseRepository, teacherRepository, accountService);
    }

    @Test
    public void checkAllDataInCourse() {
        List<CourseEntity> courseEntities = createListOfCoursesEntity();
        Mockito.when(courseRepository.findAll()).thenReturn(courseEntities);
        List<Course> actual = courseService.getAllCourses();
        List<Course> expected = createListOfCourses();
        assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getCourseName(), actual.get(i).getCourseName());
            assertEquals(expected.get(i).getStartDate(), actual.get(i).getStartDate());
            assertEquals(expected.get(i).getEndDate(), actual.get(i).getEndDate());
            assertEquals(expected.get(i).getTeacherId(), actual.get(i).getTeacherId());
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
        }
    }

    private List<CourseEntity> createListOfCoursesEntity() {
        List<CourseEntity> courseEntities = new ArrayList<>();
        courseEntities.add(createCourseEntity());
        courseEntities.add(createCourseEntity());
        return courseEntities;
    }

    private List<Course> createListOfCourses() {
        Course course = new Course();
        course.setId(id);
        course.setCourseName("first");
        course.setTeacherId(id);
        course.setStartDate(Date.valueOf("2020-12-01"));
        course.setEndDate(Date.valueOf("2020-12-05"));
        return Arrays.asList(course, course);
    }

    public CourseEntity createCourseEntity() {
        CourseEntity course = new CourseEntity();
        course.setId(id);
        course.setCourseName("first");
        course.setStartDate(Date.valueOf("2020-12-01"));
        course.setEndDate(Date.valueOf("2020-12-05"));
//        course.setTeacherId(id);
        course.setTeacherEntity(createTeacherEntity());
        return course;
    }

    public TeacherEntity createTeacherEntity() {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId("12L");
        teacher.setFirstName("tim");
        teacher.setSecondName("tim");
        teacher.setEmail("timtimtim");
        return teacher;
    }
}
