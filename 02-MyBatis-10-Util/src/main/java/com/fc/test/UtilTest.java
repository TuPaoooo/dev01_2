package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class UtilTest {
    //        <!--查询所有学生-->
    @Test
    public void testFindAll() {
        try {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (Exception e) {
            MyBatisUtil.rollback();
        }
    }


    //        <!--通过id查询学生-->
    @Test
    public void testFindById(){
        try {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

            Student student = studentDao.findById(3);

            System.out.println(student);
        } catch (Exception e){
            MyBatisUtil.rollback();
        }
    }
}
