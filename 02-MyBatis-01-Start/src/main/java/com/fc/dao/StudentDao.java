package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {
//        <!--通过id查找学生-->
    Student findById(@Param("id") Integer id);

//       <!--插入学生-->
    int insert(Student student);



}

