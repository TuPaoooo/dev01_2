package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("userDaoMySQLImpl")
public class UserDaoMySQLImpl implements UserDao {

    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(4,"oo","09876"));
        list.add(new User(5,"ii","098765"));
        list.add(new User(6,"pp","34567"));

        return list;
    }
}
