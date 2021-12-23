package com.kem.university.service;

import com.kem.university.dto.Course;
import com.kem.university.dto.Profile;
import com.kem.university.dto.Teacher;
import com.kem.university.entity.CourseEntity;
import com.kem.university.entity.TeacherEntity;
import com.kem.university.repository.TeacherRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private static final Logger LOGGER = LogManager.getLogger(TeacherService.class);
    private final TeacherRepository teacherRepository;
    private final CourseService courseService;

    public TeacherService(TeacherRepository teacherRepository,
                          CourseService courseService) {
        this.teacherRepository = teacherRepository;
        this.courseService = courseService;
    }

    public TeacherEntity addTeacher(Profile profile) {
        LOGGER.debug("Add new teacher in DB");
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(UUID.randomUUID().toString());
        teacherEntity.setFirstName(profile.getFirstName());
        teacherEntity.setSecondName(profile.getSecondName());
        teacherEntity.setEmail(profile.getEmail());
        return teacherRepository.save(teacherEntity);
    }

    public List<Course> getTeacherCourses(String name) {
        LOGGER.debug("Get list of teacher courses from DB");
        return teacherRepository.findTeachersCourses(name).stream()
                .map(courseService::convertDataToCourse)
                .collect(Collectors.toList());
    }

    public List<Teacher> getAllTeachers() {
        LOGGER.debug("Get all teachers from DB");
        return teacherRepository
                .findAll()
                .stream()
                .map(this::convertDataToTeacher)
                .collect(Collectors.toList());
    }

    public Teacher convertDataToTeacher(TeacherEntity teacherEntity) {
        LOGGER.debug("Convert data to DTO Teacher");
        if (teacherEntity == null) {
            return null;
        } else {
            return new Teacher(teacherEntity.getId(),
                    teacherEntity.getFirstName(),
                    teacherEntity.getSecondName(),
                    teacherEntity.getEmail());
        }
    }
}
