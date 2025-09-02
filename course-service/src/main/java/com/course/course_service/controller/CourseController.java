package com.course.course_service.controller;

import com.course.course_service.entity.Course;
import com.course.course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/createCourse", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping(value = "/getAllCourses",produces = "application/json")
    public ResponseEntity<List<Course>> getAllCourse() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping(value = "/getCourse/{id}", produces = "application/json")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }
}
