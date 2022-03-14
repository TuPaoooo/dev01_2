package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMySqlImpl implements UserDao {
    @Override
    public void useJDBC() {
        System.out.println("MySQL");
    }
}
