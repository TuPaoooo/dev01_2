package com.fc.dao;

import com.fc.entity.Employee;

import java.util.List;

public interface EmployeeDao {
//    <!--通过一对一的关系查找所有员工所在的部门-->
    List<Employee> findAll();
}
