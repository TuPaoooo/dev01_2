package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TernaryController {
    @RequestMapping("ternary")
    public String test(Model model) {
        model.addAttribute("name", "pp");
        model.addAttribute("age", 22);
        model.addAttribute("gender", true);
        return "ternary";
    }
}
