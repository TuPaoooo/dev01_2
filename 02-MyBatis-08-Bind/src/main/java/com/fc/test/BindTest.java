package com.fc.test;


import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class BindTest {
    //        <!--通过id查询学生-->
    @Test
    public void testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findById(7);

            System.out.println(student);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //        <!--通过IdAndName查询学生-->
    @Test
    public void testFindByIdAndName(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findByIdAndName(3,"ty");

            System.out.println(student);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// <!--通过IdAndAge查询学生-->
    @Test
    public void testFindByIdAndAge(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = studentDao.findByIdAndAge(3,18);

        System.out.println(student);

        session.commit();

        session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

//        <!--通过NameAndAge查询学生-->
@Test
public void testFindByNameAndAge(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = studentDao.findByNameAndAge("ty",18);

        System.out.println(student);

        session.commit();

        session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

//        <!--通过IdAndGender查询学生-->
@Test
public void testFindByIdAndGender(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        StudentDao studentDao = session.getMapper(StudentDao.class);

        Map<String,Object> map = new HashMap<>();
//键值对
        map.put("id",3);
        map.put("gender","男");

        Student student = studentDao.findByIdAndGender(map);

        System.out.println(student);

        session.commit();

        session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

//    <!--插入学生-->
@Test
    public void testInsert(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        StudentDao studentDao = session.getMapper(StudentDao.class);

        Student student = new Student();

        student.setName("哈奇");
        student.setAge((byte) 4);
        student.setGender("男");
        student.setInfo("胡辣汤");

        int affectedRows = studentDao.insert(student);

        System.out.println(affectedRows);

        session.commit();

        session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}

