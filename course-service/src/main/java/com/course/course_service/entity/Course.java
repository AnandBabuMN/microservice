package com.course.course_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long courseId;
    @Column(name="course_name")
    private String courseName;
    @Column(name="course_duration_in_months")
    private Long courseDurationInMonths;

    public Course() {
    }

    public Course(Long courseId, String courseName, Long courseDurationInMonths) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDurationInMonths = courseDurationInMonths;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Long getCourseDurationInMonths() {
        return courseDurationInMonths;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseDurationInMonths(Long courseDurationInMonths) {
        this.courseDurationInMonths = courseDurationInMonths;
    }
}
