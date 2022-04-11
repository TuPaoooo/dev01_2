package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    //查找所有学生
    @Select("select * from student")
    List<Student> findAll();

    //通过id查找学生
    @Select("select * from student where id = #{id}")
    Student findById(@Param("id") Integer id);

    //插入一个学生
    @Insert("insert into student(name,age,gender,info)" +
            "values (#{name},#{age},#{gender},#{info})")
    int insert(Student student);

    //删除一个学生
    @Delete("delete from student where id = #{id}")
    int delete(@Param("id") Integer id);

    //修改学生
    @Update("update student set info = #{info} where id = #{id}")
    int update(Student student);
}
