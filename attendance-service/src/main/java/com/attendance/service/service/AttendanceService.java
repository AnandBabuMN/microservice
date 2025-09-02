package com.attendance.service.service;

import com.attendance.service.entity.AttendanceEntity;
import com.attendance.service.repository.AttendanceRepo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private RestTemplate restTemplate;


    public String markAttendance(AttendanceEntity attendanceEntity) {
        Optional<AttendanceEntity> byStudentIdAndCourseIdAndAttendanceDate = attendanceRepo.findByStudentIdAndCourseIdAndAttendanceDate(attendanceEntity.getCourseId(), attendanceEntity.getStudentId(), attendanceEntity.getLocalDate());
        if (byStudentIdAndCourseIdAndAttendanceDate.isPresent()) {
            throw new ServiceException("Student attendance already marked");
        }
        try {
            String studentServiceUrl = "http://localhost:8081/student/getById/" + attendanceEntity.getStudentId();
            var student = restTemplate.getForObject(studentServiceUrl, Object.class);
        } catch (Exception e) {
            throw new ServiceException("Student was not found for Enrollment");
        }
        try {
            String courseServiceUrl = "http://localhost:8082/course/getCourse/" + attendanceEntity.getCourseId();
            var course = restTemplate.getForObject(courseServiceUrl, Object.class);
        } catch (Exception e) {
            throw new ServiceException("Course was not found for Enrollment");
        }
        attendanceRepo.save(attendanceEntity);
        return "Marked attendance for Student";
    }

    public List<AttendanceEntity> getAllAttendees(Long courseId, LocalDate attendanceDate) {
         return attendanceRepo.findByCourseAndDate(courseId, attendanceDate);
    }
}
