package com.fc.config;

import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

//声明当前类是一个配置类，相当于xml文件，会在SpringBoot
//启动的时候加载
//proxxyBeanMethods默认属性为true，代表使用cglib动态代理生成bean对象
@Configuration(proxyBeanMethods=false)
@Import(Cat.class)
public class TestConfig {
    @Bean
    public Car getCar(){
        return new Car("adlk","red");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }

    @Bean
    public Person getPerson(Car car){
        return new Person("泡泡",getCar());
    }

    //把user对象注入到容器中
    @Bean
    public User getUser(){
        return new User();
    }

    public String test() {
        System.out.println("测试方法被执行");
        return "测试";
    }
}
