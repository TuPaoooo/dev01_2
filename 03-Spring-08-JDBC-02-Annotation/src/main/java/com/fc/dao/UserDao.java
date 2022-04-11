package com.fc.dao;

import com.fc.entity.User;

import java.util.List;

public interface UserDao {
    //查询所有用户
    List<User> findAll();

    //通过id查询用户
    User findByName(String username);

    //统计用户的数量
    int findCount();

    //插入一个用户
    int insert(User user);

    //修改用户信息
    int update(User user);

    //删除用户
    int delete(String username);

}
