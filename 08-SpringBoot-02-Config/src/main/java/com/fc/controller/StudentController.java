package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
//    @Value("${student.name}")
//    private String name;
//    @Value("${student.age}")
//    private Integer age;
//    @Value("${student.gender}")
//    private String gender;
//    @Value("${student.birthday}")
//    private Date birthday;


    @Autowired
    private Student student;

    @RequestMapping("getStudent")
    public Student getStudent(){
        return student;
    }
}
