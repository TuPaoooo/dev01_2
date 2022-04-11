package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {
    @Test
    public void testFindAll(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        //需要声明当前页和每页显示多少条数据
        List<Student> all = mapper.findAll();

        for (Student student : all) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testPageInfo(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        //开启分页
        PageHelper.startPage(1,3);

        List<Student> all = mapper.findAll();

        //封装PageInfo
        PageInfo<Student> PageInfo = new PageInfo<>(all);

        System.out.println(PageInfo);

    }
}
