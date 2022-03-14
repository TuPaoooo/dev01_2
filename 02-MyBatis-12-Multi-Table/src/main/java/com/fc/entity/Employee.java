package com.fc.entity;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String name;
//    <!--通过一对一的关系查找所有员工所在的部门-->
    private Department department;
}
