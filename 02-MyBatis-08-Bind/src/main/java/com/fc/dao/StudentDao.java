package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface StudentDao {
//        <!--通过id查询学生-->
    Student findById(Integer id);

//        <!--通过IdAndName查询学生-->
    Student findByIdAndName(Integer id,String name);

// <!--通过IdAndAge查询学生-->
    Student findByIdAndAge(Integer id,Integer age);
//        <!--通过NameAndAge查询学生-->
    Student findByNameAndAge(@Param("name") String name,@Param("age") Integer age);

//        <!--通过IdAndGender查询学生-->
    Student findByIdAndGender(Map<String,Object> map);

//    <!--插入学生-->
    int insert(Student student);
}
