package com.kem.university.service;

import com.kem.university.dto.JournalCourses;
import com.kem.university.entity.CourseEntity;
import com.kem.university.entity.JournalEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.repository.AccountRepository;
import com.kem.university.repository.JournalRepository;
import com.kem.university.repository.TeacherRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JournalService {

    private static final Logger LOGGER = LogManager.getLogger(JournalService.class);
    private final JournalRepository journalRepository;
    private final TeacherRepository teacherRepository;
    private final AccountRepository accountRepository;


    public JournalService(JournalRepository journalRepository,
                          TeacherRepository teacherRepository,
                          AccountRepository accountRepository) {
        this.journalRepository = journalRepository;
        this.teacherRepository = teacherRepository;
        this.accountRepository = accountRepository;
    }

    public void editJournalCourse(String id, Long mark, String review) {
        LOGGER.debug("Edit journal course in DB");
        Optional<JournalEntity> journalEntity = journalRepository.findById(id);
        if (journalEntity.isEmpty()) {
            return;
        }
        journalEntity.get().setMark(mark);
        journalEntity.get().setReview(review);
        journalRepository.save(journalEntity.get());
    }

    public JournalCourses getJournalById(String id) {
        LOGGER.debug("Get journal course from DB");
        Optional<JournalEntity> journalEntity = journalRepository.findById(id);
        if (journalEntity.isEmpty()) {
            return new JournalCourses();
        }
        return convertDataToStudentCourse(journalEntity.get());
    }

    public List<JournalCourses> getJournalByIdCourse(String id) {
        LOGGER.debug("Get list of journal course by id course from DB");
        List<JournalEntity> journalEntities = journalRepository.findAllByCourseId(id);
        if (journalEntities == null) {
            return new ArrayList<>();
        }
        return journalEntities
                .stream()
                .map(this::convertDataToStudentCourse)
                .collect(Collectors.toList());
    }

    public void addNewCourseInJournalForStudent(List<String> coursesForAdd, String userName) {
        LOGGER.debug("Add new course for student in journal in DB");
        if (accountRepository.findByUserName(userName).isPresent()) {
            String studentId = accountRepository.findByUserName(userName).get().getStudentEntity().getId();
            for (String courseId : coursesForAdd) {
                JournalEntity journalEntity = new JournalEntity()
                        .newBuilder()
                        .setId(UUID.randomUUID().toString())
                        .setCourseId(courseId)
                        .setStudentId(studentId)
                        .build();
                journalRepository.save(journalEntity);
            }
        }
    }

    public List<JournalCourses> getStudentCourses(String id) {
        LOGGER.debug("Get student course in journal from DB by id student");
        return journalRepository.getAllByStudentId(id)
                .stream()
                .map(this::convertDataToStudentCourse)
                .collect(Collectors.toList());
    }

    public List<JournalCourses> getTeacherCourses(String id) {
        LOGGER.debug("Get all journal course by teacher id from DB");
        List<JournalCourses> studentCourses = new ArrayList<>();
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(id);
        if (teacherEntity.isEmpty()) {
            return studentCourses;
        }
        List<CourseEntity> teacherCourse = teacherEntity.get().getCourseEntities();
        for (CourseEntity entity : teacherCourse) {
            studentCourses = entity.getJournalEntity()
                    .stream()
                    .map(this::convertDataToStudentCourse)
                    .collect(Collectors.toList());
        }
        return studentCourses;
    }

    public JournalCourses convertDataToStudentCourse(JournalEntity journalEntity) {
        LOGGER.debug("Convert data to DTO JournalCourse");
        return new JournalCourses()
                .newBuilder()
                .setId(journalEntity.getId())
                .setCourseName(journalEntity.getCourseEntity().getCourseName())
                .setReview(journalEntity.getReview())
                .setStartDate(journalEntity.getCourseEntity().getStartDate())
                .setEndDate(journalEntity.getCourseEntity().getEndDate())
                .setMark(journalEntity.getMark())
                .setFirstNameStudent(journalEntity.getStudentEntity().getFirstName())
                .setSecondNameStudent(journalEntity.getStudentEntity().getSecondName())
                .build();
    }
}
