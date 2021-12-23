package com.kem.university;

import com.kem.university.dto.Course;
import com.kem.university.dto.Teacher;
import com.kem.university.entity.CourseEntity;
import com.kem.university.entity.StudentEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.repository.CourseRepository;
import com.kem.university.repository.TeacherRepository;
import com.kem.university.service.AccountService;
import com.kem.university.service.CourseService;
import com.kem.university.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeacherServiceTest {
    private TeacherService teacherService;
    private CourseService courseService;
    private TeacherRepository teacherRepository;
    private CourseRepository courseRepository;
    private AccountService accountService;
    private final String id = "1l";

    @BeforeEach
    void setUp() {
        teacherRepository = Mockito.mock(TeacherRepository.class);
        courseRepository = Mockito.mock(CourseRepository.class);
        accountService = Mockito.mock(AccountService.class);
        courseService = new CourseService(courseRepository, teacherRepository, accountService);
        teacherService = new TeacherService(teacherRepository, courseService);
    }

    @Test
    public void checkAllDataInCourse() {
        List<TeacherEntity> courseEntities = createListOfTeacherEntity();
        Mockito.when(teacherRepository.findAll()).thenReturn(courseEntities);
        List<Teacher> actual = teacherService.getAllTeachers();
        List<Teacher> expected = createListOfTeachers();
        assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
            assertEquals(expected.get(i).getFirstName(), actual.get(i).getFirstName());
            assertEquals(expected.get(i).getSecondName(), actual.get(i).getSecondName());
            assertEquals(expected.get(i).getEmail(), actual.get(i).getEmail());
        }
    }

    private List<TeacherEntity> createListOfTeacherEntity() {
        List<TeacherEntity> courseEntities = new ArrayList<>();
        courseEntities.add(createTeacherEntity());
        courseEntities.add(createTeacherEntity());
        return courseEntities;
    }

    private TeacherEntity createTeacherEntity() {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId("12L");
        teacher.setFirstName("tim");
        teacher.setSecondName("tim");
        teacher.setEmail("timtimtim");
        return teacher;
    }

    private List<Teacher> createListOfTeachers() {
        Teacher teacher = new Teacher();
        teacher.setId("12L");
        teacher.setFirstName("tim");
        teacher.setSecondName("tim");
        teacher.setEmail("timtimtim");
        return Arrays.asList(teacher, teacher);
    }
}
