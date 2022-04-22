package com.fc.controller;

import com.fc.config.TestConfig;
import com.fc.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class ConfigController {
    @Autowired
    private TestConfig config;


    @RequestMapping("get")
    public Cat test(){
        return new Cat();
    }
}
