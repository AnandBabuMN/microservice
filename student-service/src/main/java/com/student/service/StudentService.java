package com.student.service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String createStudent(Student student) {
        try {
            Student savedStudent = studentRepository.save(student);
        } catch (DataAccessException dataAccessException) {
            throw new ServiceException("Unable to save the data :" + dataAccessException);
        }
        return "Student Created successfully";
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ServiceException("Student not found"));
    }
}
