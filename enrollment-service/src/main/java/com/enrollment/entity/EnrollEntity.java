package com.enrollment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollment")
public class EnrollEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="student_id")
    private Long studentId;
    @Column(name="course_id")
    private Long courseId;
    @Column(name = "is_revert")
    private Boolean isRevert = false;

    public EnrollEntity() {
    }

    public EnrollEntity(Long id, Long studentId, Long courseId, Boolean isRevert) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.isRevert = isRevert;
    }

    public Boolean getRevert() {
        return isRevert;
    }

    public void setRevert(Boolean revert) {
        isRevert = revert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

