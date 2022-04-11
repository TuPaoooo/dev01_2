package com.fc.test;

import com.fc.dao.DepartmentDao;
import com.fc.entity.Department;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

public class LazyLoadTest {
    @Test
    public void test(){
        DepartmentDao mapper = MyBatisUtil.getMapper(DepartmentDao.class);

        Department byDepartmentId = mapper.findByDepartmentId(3);

        System.out.println(byDepartmentId);

        MyBatisUtil.commit();
    }
}
