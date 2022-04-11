package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(1,"tt","12345"));
        list.add(new User(2,"ll","12345"));
        list.add(new User(3,"uu","987"));

        return list;
    }
}
