package com.kem.university.service;

import com.kem.university.dto.Profile;
import com.kem.university.dto.Student;
import com.kem.university.entity.StudentEntity;
import com.kem.university.repository.AccountRepository;
import com.kem.university.repository.StudentRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StudentService {

    private static final Logger LOGGER = LogManager.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository, AccountRepository accountRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity addStudent(Profile profile) {
        LOGGER.debug("Add new Student in DB");
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID().toString());
        studentEntity.setFirstName(profile.getFirstName());
        studentEntity.setSecondName(profile.getSecondName());
        studentEntity.setEmail(profile.getEmail());
        return studentRepository.save(studentEntity);
    }

    public Student convertDataToStudent(StudentEntity studentEntity) {
        LOGGER.debug("Convert data to DTO Student");
        if (studentEntity == null) {
            return null;
        } else {
            return new Student(studentEntity.getId(),
                    studentEntity.getFirstName(),
                    studentEntity.getSecondName(),
                    studentEntity.getEmail());
        }
    }
}
