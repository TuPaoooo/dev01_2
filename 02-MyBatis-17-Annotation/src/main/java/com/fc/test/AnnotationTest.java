package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class AnnotationTest {

    //查找所有学生
    @Test
    public void testFindAll(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> all = mapper.findAll();

        for (Student student : all) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    //通过id查找学生
    @Test
    public void testFindById(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student byId = mapper.findById(3);

        System.out.println(byId);

        MyBatisUtil.commit();
    }

    //插入一个学生
    @Test
    public void testInsert(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setName("pop");
        student.setAge((byte) 9);
        student.setGender("男");
        student.setInfo("follow");

        int insert = mapper.insert(student);

        MyBatisUtil.commit();
    }

    //删除一个学生
    @Test
    public void testDelete(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        int delete = mapper.delete(40);

        MyBatisUtil.commit();
    }

    //修改学生
    @Test
    public void testUpdate(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(3);
        student.setAge((byte) 7);

        int update = mapper.update(student);

        MyBatisUtil.commit();
    }
}
