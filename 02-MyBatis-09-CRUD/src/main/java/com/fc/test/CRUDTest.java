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

public class CRUDTest {
    //        <!--查找所有学生-->
    @Test
    public void testFindAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            for (Student student:students) {
                System.out.println(student);
            }

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //      <!--通过id查找学生-->
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

    //    <!--插入学生-->
    @Test
    public void testInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("皮特");
            student.setAge((byte) 24);
            student.setGender("男");
            student.setInfo("油条");

            int affectedRows = studentDao.insert(student);

            System.out.println(affectedRows);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//      <!--删除学生-->
    @Test
    public void testDelete(){
        try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();

        StudentDao studentDao = session.getMapper(StudentDao.class);

        int affectedRows = studentDao.delete(7);

        System.out.println(affectedRows);

        session.commit();

        session.close();

        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    //      <!--修改学生信息-->
    @Test
    public void testUpdate(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setId(8);
            student.setAge((byte) 3);

            int affectedRows = studentDao.update(student);

            System.out.println(affectedRows);

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //      <!--模糊查询-->
    @Test
    public void testFindByKeyword(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findByKeyword("%小%");

            for (Student student:students) {
                System.out.println(student);
            }

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    主键回填
    @Test
    public void testGetAutoIncrement(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("帕尼");
            student.setAge((byte) 21);
            student.setGender("男");
            student.setInfo("蛋糕！！！");

            System.out.println(student);

            int affectedRows = studentDao.getAutoIncrement(student);

            System.out.println(affectedRows);

            System.out.println("自增长的id："+student.getId());

            session.commit();

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
