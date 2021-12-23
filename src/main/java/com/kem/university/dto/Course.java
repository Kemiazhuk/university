package com.kem.university.dto;

import java.sql.Date;

public class Course {
    private String id;
    private String courseName;
    private Date startDate;
    private Date endDate;
    private String teacherId;
    private String firsTeacherName;
    private String secondTeacherName;

    public Course() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirsTeacherName() {
        return firsTeacherName;
    }

    public void setFirsTeacherName(String firsTeacherName) {
        this.firsTeacherName = firsTeacherName;
    }

    public String getSecondTeacherName() {
        return secondTeacherName;
    }

    public void setSecondTeacherName(String secondTeacherName) {
        this.secondTeacherName = secondTeacherName;
    }

    public Builder newBuilder() {
        return new Course().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(String id) {
            Course.this.id = id;
            return this;
        }

        public Builder setCourseName(String courseName) {
            Course.this.courseName = courseName;

            return this;
        }

        public Builder setStartDate(Date setStartDate) {
            Course.this.startDate = setStartDate;

            return this;
        }

        public Builder setEndDate(Date endDate) {
            Course.this.endDate = endDate;

            return this;
        }

        public Builder setTeacherId(String teacherId) {
            Course.this.teacherId = teacherId;

            return this;
        }

        public Builder setFirstTeacherName(String firstTeacherName) {
            Course.this.firsTeacherName = firstTeacherName;

            return this;
        }

        public Builder setSecondTeacherName(String secondTeacherName) {
            Course.this.secondTeacherName = secondTeacherName;

            return this;
        }

        public Course build() {
            return Course.this;
        }

    }
}
