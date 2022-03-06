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
import java.util.List;

public class CharacterTest {
    //        <!--查找小于指定年龄的学生-->
    @Test
    public void testFindLessThanAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findLessThanAge(15);

            for (Student student:students) {
                System.out.println(student);
            }

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //        <!--查找大于指定年龄的学生-->
    @Test
    public void testFindGrateThanAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findGrateThanAge(8);

            for (Student student:students) {
                System.out.println(student);
            }

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
