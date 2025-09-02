package com.enrollment.service;

import com.enrollment.dto.RevertCourseDto;
import com.enrollment.entity.EnrollEntity;
import com.enrollment.repository.EnrollRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String createEnrollment(EnrollEntity enrollEntity) {
        try {

            try {
                String studentServiceUrl = "http://localhost:8081/student/getById/" + enrollEntity.getStudentId();
                var student = restTemplate.getForObject(studentServiceUrl, Object.class);
            } catch (Exception e) {
                throw new ServiceException("Student was not found for Enrollment");
            }
            try {
                String courseServiceUrl = "http://localhost:8082/course/getCourse/" + enrollEntity.getCourseId();
                var course = restTemplate.getForObject(courseServiceUrl, Object.class);
            } catch (Exception e) {
                throw new ServiceException("Course was not found for Enrollment");
            }
            EnrollEntity savedStudent = enrollRepository.save(enrollEntity);
        } catch (DataAccessException dataAccessException) {
            throw new ServiceException("Unable to save the data :" + dataAccessException);
        }
        return "Student Enrolled successfully";
    }

    public String revertEnrollment(RevertCourseDto revertCourseDto) {
        EnrollEntity enrollEntity = enrollRepository.findByStudentIdAndCourseId(revertCourseDto.getStudentId(), revertCourseDto.getCourseId()).orElseThrow(() -> new ServiceException("No Enrollments found for Student"));
        enrollEntity.setRevert(revertCourseDto.getRevert());
        enrollRepository.save(enrollEntity);
        return "Student with ID : " + revertCourseDto.getStudentId() + " is reverted from the Course";
    }

    public List<EnrollEntity> getEnrollmentsForStudentId(Long id) {
        return enrollRepository.findByStudentId(id);
    }
}
