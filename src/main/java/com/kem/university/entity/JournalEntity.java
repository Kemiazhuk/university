package com.kem.university.entity;

import com.kem.university.dto.Course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "STUDENT_COURSE")
public class JournalEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "mark")
    private Long mark;

    @Column(name = "review")
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private CourseEntity courseEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }
    public JournalEntity.Builder newBuilder() {
        return new JournalEntity().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public JournalEntity.Builder setId(String id) {
            JournalEntity.this.id = id;
            return this;
        }

        public JournalEntity.Builder setStudentId(String studentId) {
            JournalEntity.this.studentId = studentId;

            return this;
        }

        public JournalEntity.Builder setCourseId(String courseId) {
            JournalEntity.this.courseId = courseId;

            return this;
        }

        public JournalEntity.Builder setMark(Long mark) {
            JournalEntity.this.mark = mark;

            return this;
        }

        public JournalEntity.Builder setReview(String review) {
            JournalEntity.this.review = review;

            return this;
        }

        public JournalEntity build() {
            return JournalEntity.this;
        }

    }
}
