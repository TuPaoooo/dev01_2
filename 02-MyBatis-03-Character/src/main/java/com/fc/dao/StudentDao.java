package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
//        <!--查找小于指定年龄的学生-->
    List<Student> findLessThanAge(@Param("age") Integer age);

//        <!--查找大于指定年龄的学生-->
    List<Student> findGrateThanAge(@Param("age") Integer age);
}
