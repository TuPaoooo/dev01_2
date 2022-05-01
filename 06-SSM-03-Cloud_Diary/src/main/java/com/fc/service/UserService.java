package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    //登录
    ModelAndView login(HttpServletRequest req, HttpServletResponse resp);




}
