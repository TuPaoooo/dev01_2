package com.fc.test;

import com.fc.config.ApplicationContextConfig;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class UserTest {
    //查询所有用户
    @Test
    public void testFindAll(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);


        UserDao userDao = annotationConfigApplicationContext.getBean(UserDao.class);

        List<User> users = userDao.findAll();

        System.out.println(users);
    }

    //通过name查询用户
    @Test
    public void testFindById(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = annotationConfigApplicationContext.getBean(UserDao.class);

        User user = userDao.findByName("ty");

        System.out.println(user);
    }

    //统计用户的数量
    @Test
    public void testFindCount(){
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);


        UserDao userDao = annotationConfigApplicationContext.getBean(UserDao.class);

        int count = userDao.findCount();

        System.out.println(count);

    }

    //插入一个用户
    @Test
    public void testInsert(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao bean = annotationConfigApplicationContext.getBean(UserDao.class);

        User user = new User();
        user.setUsername("oo");
        user.setPassword("456789");

        int affectedRows = bean.insert(user);

        System.out.println(affectedRows);
    }

    //修改用户信息
    @Test
    public void testUpdate(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao bean = annotationConfigApplicationContext.getBean(UserDao.class);

        User user = new User();
        user.setUsername("oo");
        user.setPassword("4567890");

        int affectedRows = bean.update(user);

        System.out.println(affectedRows);
    }

    //删除用户
    @Test
    public void testDelete(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao bean = annotationConfigApplicationContext.getBean(UserDao.class);

        int delete = bean.delete("oo");

        System.out.println(delete);
    }

}
