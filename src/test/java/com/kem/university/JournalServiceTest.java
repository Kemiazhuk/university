package com.kem.university;

import com.kem.university.dto.JournalCourses;
import com.kem.university.entity.CourseEntity;
import com.kem.university.entity.JournalEntity;
import com.kem.university.entity.StudentEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.repository.AccountRepository;
import com.kem.university.repository.JournalRepository;
import com.kem.university.repository.TeacherRepository;
import com.kem.university.service.JournalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


class JournalServiceTest {
    private JournalService journalService;

    private JournalRepository journalRepository;

    private TeacherRepository teacherRepository;

    private AccountRepository accountRepository;
    private final String id = "1l";

    @BeforeEach
    void setUp() {
        journalRepository = Mockito.mock(JournalRepository.class);
        teacherRepository = Mockito.mock(TeacherRepository.class);
        accountRepository = Mockito.mock(AccountRepository.class);
        journalService = new JournalService(journalRepository, teacherRepository, accountRepository);
    }

    @Test
    public void checkAllDataInJournal() {
        List<JournalEntity> journal = createListOfJournalCoursesEntity();
        Mockito.when(journalRepository.getAllByStudentId(id)).thenReturn(journal);
        List<JournalCourses> actual = journalService.getStudentCourses(id);
        List<JournalCourses> expected = createListOfJournalCourses();
        assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getCourseName(), actual.get(i).getCourseName());
            assertEquals(expected.get(i).getStartDate(), actual.get(i).getStartDate());
            assertEquals(expected.get(i).getEndDate(), actual.get(i).getEndDate());
            assertEquals(expected.get(i).getMark(), actual.get(i).getMark());
            assertEquals(expected.get(i).getReview(), actual.get(i).getReview());
            assertEquals(expected.get(i).getFirstNameStudent(), actual.get(i).getFirstNameStudent());
            assertEquals(expected.get(i).getSecondNameStudent(), actual.get(i).getSecondNameStudent());
        }

    }

    private List<JournalCourses> createListOfJournalCourses() {
        JournalCourses journalCourses = new JournalCourses()
                .newBuilder()
                .setCourseName("first")
                .setReview("good")
                .setStartDate(Date.valueOf("2020-12-01"))
                .setEndDate(Date.valueOf("2020-12-05"))
                .setMark(5l)
                .setFirstNameStudent("tim")
                .setSecondNameStudent("tim")
                .build();
        return Arrays.asList(journalCourses, journalCourses);
    }

    private List<JournalEntity> createListOfJournalCoursesEntity() {
        JournalEntity journalEntity = new JournalEntity();
        journalEntity.setId("1L");
        journalEntity.setMark(5l);
        journalEntity.setCourseId("1L");
        journalEntity.setReview("good");
        journalEntity.setCourseEntity(createCourseEntity());
        journalEntity.setCourseEntity(createCourseEntity());
        journalEntity.setStudentEntity(createStudentEntity());
        return Arrays.asList(journalEntity, journalEntity);
    }

    public CourseEntity createCourseEntity() {
        CourseEntity course = new CourseEntity();
        course.setId("1L");
        course.setCourseName("first");
        course.setStartDate(Date.valueOf("2020-12-01"));
        course.setEndDate(Date.valueOf("2020-12-05"));
//        course.setTeacherId("12L");
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

    public StudentEntity createStudentEntity() {
        StudentEntity student = new StudentEntity();
        student.setId("1L");
        student.setFirstName("firstStudent");
        student.setSecondName("secondStudent");
        student.setEmail("email@email.com");
        student.setJournalEntity(null);
        return student;
    }
}
