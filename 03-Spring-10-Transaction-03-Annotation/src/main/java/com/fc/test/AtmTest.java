package com.fc.test;

import com.fc.config.TxtConfig;
import com.fc.service.AtmService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AtmTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxtConfig.class);

        AtmService atmService = applicationContext.getBean(AtmService.class);

        atmService.transfer(1,2, 200L);
    }

    @Test
    public void testXml(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AtmService annotationService = applicationContext.getBean("annotationService", AtmService.class);

        annotationService.transfer(1,2,200L);

    }
}
