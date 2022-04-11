package com.fc.dao.impl;

import com.fc.dao.AtmDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AtmDaoImpl extends JdbcDaoSupport implements AtmDao {


    @Override
    public void increaseMoney(Integer id, Long money) {
        //执行sql语句
        getJdbcTemplate().update("update atm set money = money + ? where id = ?",money,id);

        System.out.println("加钱成功");
    }

    @Override
    public void decreaseMoney(Integer id, Long money) {
        getJdbcTemplate().update("update atm set money = money - ? where id = ?",money,id);

        System.out.println("减钱成功！");
    }
}
