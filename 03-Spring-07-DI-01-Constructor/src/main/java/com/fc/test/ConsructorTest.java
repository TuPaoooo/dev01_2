package com.fc.test;

import com.fc.entity.Car;
import com.fc.entity.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsructorTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = applicationContext.getBean("car", Car.class);

        Person person = applicationContext.getBean("person", Person.class);

        System.out.println(car);
        System.out.println(person);

        applicationContext.close();

    }
}
