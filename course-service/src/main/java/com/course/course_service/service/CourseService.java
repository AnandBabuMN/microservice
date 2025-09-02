package com.course.course_service.service;

import com.course.course_service.entity.Course;
import com.course.course_service.repository.CourseRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public String createCourse(Course course) {
        try {
            Course Course = courseRepository.save(course);
        } catch (DataAccessException dataAccessException) {
            throw new ServiceException("Unable to save the data :" + dataAccessException);
        }
        return "Course Created successfully";
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new ServiceException("Course not found"));
    }
}
