package com.fc.service;

import com.fc.entity.TbUser;
import com.fc.vo.ResultVo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public interface UserService {

    //登录
    ResultVo login(String username, String password);

    //退出登录
    ModelAndView logout(HttpSession session, HttpServletResponse response, HttpServletRequest request, ModelAndView mv);

    //进入个人中心
    ModelAndView userCenter(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelAndView mv);

    //修改用户信息
    ModelAndView update(MultipartFile img, HttpServletRequest request, TbUser user);

}
