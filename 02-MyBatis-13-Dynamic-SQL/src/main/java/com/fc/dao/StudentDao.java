package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
//    <!--查找所有学生-->
    List<Student> findAll();

//    <!--通过id查找学生-->
    Student findById(@Param("id") Integer id);

//    <!--模糊查询-->
    List<Student> findByKeyword(@Param("name") String name , @Param("info") String info);

//    <!--通过条件查询学生-->
    List<Student> findByStudent(Student student);

//    <!--trim可以声明指定的前后缀以及忽略指定的前后缀-->
    List<Student> findByStudentOnTrim(Student student);

//    <!--通过set标签和if标签修改学生表-->
    int update(Student student);

    int updateOnTrim(Student student);

//     <!--删除指定区间的学生-->
    int delete(Integer... ids);

}
