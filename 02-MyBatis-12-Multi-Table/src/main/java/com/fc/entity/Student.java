package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data

public class Student {
    private Integer id;
    private String name;
    private Byte age;
    private String gender;
    private String info;
//    一个学生可以选择多个课程
    private List<Subject> subjects;
}
