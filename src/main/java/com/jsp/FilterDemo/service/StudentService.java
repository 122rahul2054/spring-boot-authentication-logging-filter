package com.jsp.FilterDemo.service;

import com.jsp.FilterDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student) {

        System.out.println("Student is created");

        System.out.println("ID: " + student.getId());

        System.out.println("Name: " + student.getName());

        System.out.println("Email: " + student.getEmail());

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}