package com.fc.controller;

import com.fc.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//此注解用于将当前类注入到SPringle容器中，并跳过视图解析器
@RestController
@RequestMapping("annotation")
public class TestRestControllerAnnotationController {

    @RequestMapping("getUser")
    public User getUser(){
        return new User("泡泡","67890");
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "/index.jsp";
    }

}
