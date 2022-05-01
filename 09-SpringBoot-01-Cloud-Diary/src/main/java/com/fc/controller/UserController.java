package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ModelAndView login(TbUser user,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv) {
        //调用业务层的登录方法
        ResultVo result = userService.login(user.getUsername(), user.getPassword());

        Cookie cookie;

        //登陆成功的情况
        if (result.getCode() == 200) {
            session.setAttribute("user", result.getData());

            if (remember != null && remember == 1) {
                //勾选记住我
                cookie = new Cookie("JSESSIONID", session.getId());
                //半小时
                cookie.setMaxAge(30 * 60);

            } else {
                cookie = new Cookie("JSESSIONID", null);

                //浏览器关闭时自动销毁
                cookie.setMaxAge(-1);

            }
            //发送到浏览器
            response.addCookie(cookie);

            mv.setViewName("/index.jsp");
        } else {
            //登陆失败
            mv.addObject("resultInfo", result);
            mv.setViewName("redirect:/login.jsp");
        }

        return mv;
    }

    //退出登录
    @GetMapping("logout")
    public ModelAndView logout(HttpSession session,
                               HttpServletResponse response,
                               HttpServletRequest request,
                               ModelAndView mv) {

        return userService.logout(session, response, request, mv);

    }

    //进入个人中心
    @GetMapping("userCenter")
    public ModelAndView userCenter(HttpServletRequest request,
                                   HttpServletResponse response,
                                   ModelAndView mv) {
        return userService.userCenter(request, response, mv);
    }

    //修改用户信息
    @PostMapping("update")
    public ModelAndView update(MultipartFile img, HttpServletRequest request ,TbUser user){
        return userService.update(img,request,user);
    }


}
