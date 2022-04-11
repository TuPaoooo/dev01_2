package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class DruidTest {
    @Test
    public void testFindAll(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> all = mapper.findAll();

        MyBatisUtil.commit();
    }
}
