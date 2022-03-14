package com.fc.dao;

import com.fc.entity.Account;

import java.util.List;

public interface AccountDao {
//<!--查询所有学生,通过起别名来进行映射-->
    List<Account> findAll();
//<!--查询所有学生,通过resultMap来进行映射-->
    List<Account> findAllOnMap();

}
