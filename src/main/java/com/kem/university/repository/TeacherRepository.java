package com.kem.university.repository;

import com.kem.university.entity.CourseEntity;
import com.kem.university.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<TeacherEntity, String> {

    List<TeacherEntity> findAll();

    TeacherEntity findByFirstNameAndSecondName(String firstName, String secondName);

    @Query(value = "select c1 from CourseEntity c1 " +
            "join AccountEntity a on c1.teacherId = a.teacherEntity.id where a.userName=?1",
            nativeQuery = false)
    List<CourseEntity> findTeachersCourses(String name);

}
