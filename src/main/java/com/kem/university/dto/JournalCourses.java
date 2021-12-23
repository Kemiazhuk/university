package com.kem.university.dto;

import java.sql.Date;

public class JournalCourses {

    private String id;
    private String courseName;
    private String review;
    private Date startDate;
    private Date endDate;
    private Long mark;
    private String firstNameStudent;
    private String secondNameStudent;

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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    public String getFirstNameStudent() {
        return firstNameStudent;
    }

    public void setFirstNameStudent(String firstNameStudent) {
        this.firstNameStudent = firstNameStudent;
    }

    public String getSecondNameStudent() {
        return secondNameStudent;
    }

    public void setSecondNameStudent(String secondNameStudent) {
        this.secondNameStudent = secondNameStudent;
    }

    public JournalCourses.Builder newBuilder() {
        return new JournalCourses().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public JournalCourses.Builder setId(String id) {
            JournalCourses.this.id = id;
            return this;
        }

        public JournalCourses.Builder setCourseName(String courseName) {
            JournalCourses.this.courseName = courseName;
            return this;
        }

        public JournalCourses.Builder setReview(String review) {
            JournalCourses.this.review = review;
            return this;
        }

        public JournalCourses.Builder setStartDate(Date startDate) {
            JournalCourses.this.startDate = startDate;
            return this;
        }

        public JournalCourses.Builder setEndDate(Date endDate) {
            JournalCourses.this.endDate = endDate;
            return this;
        }

        public JournalCourses.Builder setMark(Long mark) {
            JournalCourses.this.mark = mark;
            return this;
        }

        public JournalCourses.Builder setFirstNameStudent(String firstNameStudent) {
            JournalCourses.this.firstNameStudent = firstNameStudent;
            return this;
        }

        public JournalCourses.Builder setSecondNameStudent(String secondNameStudent) {
            JournalCourses.this.secondNameStudent = secondNameStudent;
            return this;
        }

        public JournalCourses build() {
            return JournalCourses.this;
        }

    }
}
