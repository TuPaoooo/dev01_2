package com.fc.controller;

import com.fc.entity.Car;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("selective")
public class SelectiveExpressionController {

    @RequestMapping("test")
    public String testSelective(Model model){
        User user = new User(1, "胡歌", 42, "男", "胡歌最帅", new Car("兰博基尼", "红色"));
        model.addAttribute("user",user);
        return "selective";
    }


}
