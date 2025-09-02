package com.attendance.service.repository;

import com.attendance.service.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepo extends JpaRepository<AttendanceEntity, Long> {

    @Query(value = "select * from attendance_table where course_id = ?1 and student_id = ?2 and attendance_date = ?3;", nativeQuery = true)
    Optional<AttendanceEntity> findByStudentIdAndCourseIdAndAttendanceDate(Long courseId, Long studentId, LocalDate attendanceDate);

    @Query(value = "select * from attendance_table where course_id = ?1 and attendance_date = ?2", nativeQuery = true)
    List<AttendanceEntity> findByCourseAndDate(Long courseId, LocalDate attendanceDate);
}
