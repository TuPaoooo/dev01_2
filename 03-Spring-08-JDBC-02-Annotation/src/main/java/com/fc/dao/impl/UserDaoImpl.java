package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //查询所有用户
    @Override
    public List<User> findAll() {
        String sql = "select * from user";

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }

    //通过name查询用户
    @Override
    public User findByName(String username) {
        String sql = "select * from user where username = ?";

        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);

        return user;
    }

    //统计用户的数量
    @Override
    public int findCount() {
        String sql = "select count(1) from user";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

        return count;
    }

    //插入一个用户
    @Override
    public int insert(User user) {
        String sql = "insert into user (username,password) values(?,?)";

        int affectedRows = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());

        return affectedRows;
    }

    //修改用户信息
    @Override
    public int update(User user) {
        String sql = "update user set password = ? where username = ?";

        int update = jdbcTemplate.update(sql, user.getPassword(), user.getUsername());

        return update;
    }

    //删除用户
    @Override
    public int delete(String username) {
        String sql = "delete from user where username = ?";

        int update = jdbcTemplate.update(sql,username);

        return update;
    }





}
