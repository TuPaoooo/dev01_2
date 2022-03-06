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

public class MybatisTest {
    //        <!--通过id查找学生-->
    @Test
    public void testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findById(3);

            System.out.println(student);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//       <!--插入学生-->
    @Test
    public void testInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setId(40);
            student.setName("帕帕");
            student.setAge((byte) 7);
            student.setGender("男");
            student.setInfo("包子真好吃");

            int affectedRows = studentDao.insert(student);

            System.out.println(affectedRows);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
