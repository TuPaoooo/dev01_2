package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
//    通过学生的id查询该学生选的所有课程
    List<Student> findAllWithSubject();
}
