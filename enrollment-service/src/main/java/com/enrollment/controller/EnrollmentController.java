package com.enrollment.controller;

import com.enrollment.dto.RevertCourseDto;
import com.enrollment.entity.EnrollEntity;
import com.enrollment.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollService enrollService;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "/createEnrollment")
    public ResponseEntity<String> createEnrollment(@RequestBody EnrollEntity enrollEntity) {
        return new ResponseEntity<>(enrollService.createEnrollment(enrollEntity), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/revertEnrollment",produces = "application/json")
    public ResponseEntity<String> revertEnrollment(@RequestBody RevertCourseDto revertCourseDto) {
        return new ResponseEntity<>(enrollService.revertEnrollment(revertCourseDto), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping(value = "/getEnrollmentByStudentId/{id}", produces = "application/json")
    public ResponseEntity<List<EnrollEntity>> getEnrollmentByStudentId(@PathVariable Long id) {
        return new ResponseEntity<>(enrollService.getEnrollmentsForStudentId(id), HttpStatus.OK);
    }
}
