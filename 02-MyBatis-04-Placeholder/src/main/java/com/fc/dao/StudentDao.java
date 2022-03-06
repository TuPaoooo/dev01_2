package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
//        <!--根据年龄查找学生-->
    List<Student> findByAge(@Param("age") Integer age);
}
