package com.kem.university.repository;

import com.kem.university.entity.JournalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<JournalEntity, String> {
    List<JournalEntity> findAllByCourseId(String id);

    List<JournalEntity> getAllByStudentId(String id);
}
