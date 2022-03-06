package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
//        <!--查找所有学生-->
  List<Student> findAll();
//      <!--通过id查找学生-->
  Student findById(@Param("id") Integer id);



}

