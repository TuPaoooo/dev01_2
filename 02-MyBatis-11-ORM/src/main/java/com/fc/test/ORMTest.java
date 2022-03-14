package com.fc.test;

import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class ORMTest {
    //<!--查询所有学生,通过起别名来进行映射-->
    @Test
    public void FindAllTest(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }

        MyBatisUtil.commit();
    }

    //<!--查询所有学生,通过resultMap来进行映射-->
    @Test
    public void FindAllOnMapTest(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAllOnMap();

        for (Account account : accounts) {
            System.out.println(account);
        }

        MyBatisUtil.commit();
    }
}
