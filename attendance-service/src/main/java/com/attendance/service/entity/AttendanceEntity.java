package com.attendance.service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "attendance_table")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "is_present")
    private Boolean isPresent = true;
    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    public AttendanceEntity() {
    }

    public AttendanceEntity(Long id, Long studentId, Long courseId, Boolean isPresent, LocalDate localDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.isPresent = isPresent;
        this.attendanceDate = localDate;
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

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    public LocalDate getLocalDate() {
        return attendanceDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.attendanceDate = localDate;
    }
}
