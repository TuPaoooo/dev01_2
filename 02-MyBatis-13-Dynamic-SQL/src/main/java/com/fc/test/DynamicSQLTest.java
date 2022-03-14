package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class DynamicSQLTest {
//使用动态sql查询所有
    @Test
    public void testFindAll(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> all = mapper.findAll();

        for (Student student : all) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    //    <!--通过id查找学生-->
    @Test
    public void testFindById(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student byId = mapper.findById(3);

        System.out.println(byId);

        MyBatisUtil.commit();
    }

    //    <!--模糊查询-->
    @Test
    public void testFindByKeyword(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> byKeyword = mapper.findByKeyword("%小%","%r%");

        for (Student student : byKeyword) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    //    <!--通过条件查询学生-->
    @Test
    public void testFindByStudent(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setName("uu");
        student.setGender("女");
        student.setAge((byte) 3);

        List<Student> students = mapper.findByStudent(student);

        for (Student student1 : students) {
            System.out.println(student1);
        }

        MyBatisUtil.commit();
    }

    //    <!--trim可以声明指定的前后缀以及忽略指定的前后缀-->
    @Test
    public void testFindByStudentOnTrim(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setName("小花");
//        student.setGender("女");
        student.setAge((byte) 3);

        List<Student> byStudentOnTrim = mapper.findByStudentOnTrim(student);

        for (Student student1 : byStudentOnTrim) {
            System.out.println(student1);
        }

        MyBatisUtil.commit();
    }

    //    <!--通过set标签和if标签修改学生表-->
    @Test
    public void testUpdate(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(1);
        student.setInfo("喜欢你");


        int affectedRows = mapper.update(student);

        System.out.println(affectedRows);

        MyBatisUtil.commit();
    }

    @Test
    public void tesUpdateOnTrim(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(1);
        student.setInfo("无语");

        int affectedRows = mapper.updateOnTrim(student);

        System.out.println(affectedRows);

        MyBatisUtil.commit();

    }

    //     <!--删除指定区间的学生-->
    @Test
    public void testDelete(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        int delete = mapper.delete(32, 33, 34);

        System.out.println(delete);

        MyBatisUtil.commit();
    }

}
