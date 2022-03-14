package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Subject {
    private Integer id;
    private String name;
//    一个课程可以被多个学生选择
    List<Student> students;
}
