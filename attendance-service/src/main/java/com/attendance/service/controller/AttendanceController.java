package com.attendance.service.controller;

import com.attendance.service.entity.AttendanceEntity;
import com.attendance.service.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PreAuthorize("hasRole('STAFF')")
    @PostMapping("markAttendance")
    public ResponseEntity<String> markAttendance (@RequestBody AttendanceEntity attendanceEntity) {
        return new ResponseEntity<>(attendanceService.markAttendance(attendanceEntity), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STAFF')")
    @GetMapping("getAttendeesForDate")
    public ResponseEntity<List<AttendanceEntity>> getAllAttendees (@RequestParam Long courseId, @RequestParam LocalDate attendanceDate) {
        return new ResponseEntity<>(attendanceService.getAllAttendees(courseId, attendanceDate), HttpStatus.OK);
    }
}
