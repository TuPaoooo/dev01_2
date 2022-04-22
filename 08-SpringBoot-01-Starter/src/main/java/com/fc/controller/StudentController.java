package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private String age;
    @Value("${student.gender}")
    private String gender;
    @Value("${student.info}")
    private String info;

    @Autowired
    Student student;

    @RequestMapping("getStudent")
    public Student getStudent() {
        return student;
    }
}
