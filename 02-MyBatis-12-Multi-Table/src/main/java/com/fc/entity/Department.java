package com.fc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer id;
    private String name;
//    <!--一对多的关系映射，通过部门id查找该部门的所有员工-->
    private List<Employee> employee;
}
