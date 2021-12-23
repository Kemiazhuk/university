package com.kem.university.repository;

import com.kem.university.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {
    CourseEntity findByCourseName(String nameCourse);

    List<CourseEntity> findAll();

    List<CourseEntity> findAllByTeacherId(String id);

//    List<CourseEntity> findAllByStartDateBetween(Date startDate, Date endDate);

    @Query(value = "select c2 from CourseEntity c2 where c2.id not in " +
            "(select j.courseId from JournalEntity j " +
            "join AccountEntity a on j.studentId = a.studentEntity.id where a.userName=?1)",
            nativeQuery = false)
    List<CourseEntity> findCoursesForStudent(String userName);

    @Query(value = "select c from CourseEntity  c where c.id in " +
            "(select j.courseId from JournalEntity j " +
            "join AccountEntity a on j.studentId = a.studentEntity.id where a.userName=?1)",
            nativeQuery = false)
    List<CourseEntity> findStudentCourseByUserName(String userName);
}
