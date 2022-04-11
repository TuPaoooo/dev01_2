package com.fc.test;

import com.fc.service.AtmService;
import com.fc.service.impl.StatementServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtmTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AtmService bean = applicationContext.getBean(StatementServiceImpl.class);

        bean.transfer(1,2,500L);


    }
}
