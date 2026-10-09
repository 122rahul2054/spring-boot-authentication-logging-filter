package com.jsp.FilterDemo.controller;

import com.jsp.FilterDemo.dto.Student;
import com.jsp.FilterDemo.service.StudentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody Student student) {

        studentService.createStudent(student);

        return ResponseEntity.ok("Student created successfully");
    }
}