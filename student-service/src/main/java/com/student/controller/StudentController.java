package com.student.controller;

import com.student.entity.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/createStudent")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping(value = "/getAllStudents",produces = "application/json")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping(value = "/getById/{id}", produces = "application/json")
    public ResponseEntity<Student> getAllStudents(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }
}
