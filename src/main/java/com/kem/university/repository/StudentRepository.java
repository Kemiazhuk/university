package com.kem.university.repository;

import com.kem.university.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    Optional<StudentEntity> findById(String id);
}
