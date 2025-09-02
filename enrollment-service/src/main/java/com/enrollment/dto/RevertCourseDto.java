package com.enrollment.dto;

public class RevertCourseDto {
    private Long studentId;
    private Long courseId;
    private Boolean isRevert;

    public RevertCourseDto(Long studentId, Long courseId, Boolean isRevert) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.isRevert = isRevert;
    }

    public RevertCourseDto() {
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

    public Boolean getRevert() {
        return isRevert;
    }

    public void setRevert(Boolean revert) {
        isRevert = revert;
    }
}
