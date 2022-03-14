package com.fc.dao;


import com.fc.entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDao {
//    <!--一对多的关系映射，通过部门id查找该部门的所有员工-->
    Department findById(@Param("id") Integer id);
}
