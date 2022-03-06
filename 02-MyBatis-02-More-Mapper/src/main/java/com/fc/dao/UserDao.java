package com.fc.dao;

import com.fc.entity.User;

import java.util.List;

public interface UserDao {
//        <!--查找所有用户-->
    List<User> findAll();
}
