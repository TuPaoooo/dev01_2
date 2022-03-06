package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
//        <!--查找所有学生-->
  List<Student> findAll();
//      <!--通过id查找学生-->
  Student findById(@Param("id") Integer id);

  //    <!--插入学生-->
  int insert(Student student);

//      <!--删除学生-->
  int delete(@Param("id") Integer id);

//      <!--修改学生信息-->
  int update(Student student);

//      <!--模糊查询-->
  List<Student> findByKeyword(@Param("keyword") String keyword);

//  主键回填
  int getAutoIncrement(Student student);
}

