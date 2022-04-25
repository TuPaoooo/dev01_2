package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


//    @RequestMapping("login")
//    public ResultVO login(String username,String password){
//       return userService.login(username, password);
//    }

    @RequestMapping("login")

    public ModelAndView login(TbUser user, HttpSession session) {
        Boolean flag = userService.login(user);
        session.setAttribute("user",user.getUsername());

        ModelAndView mv = new ModelAndView();
        if (flag) {
            mv.setViewName("user_id");
        } else {
            mv.setViewName("error");
        }
        return mv;


    }
}
