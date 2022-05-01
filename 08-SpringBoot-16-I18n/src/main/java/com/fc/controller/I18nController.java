package com.fc.controller;

import com.fc.util.MessageUtil;
import com.fc.vo.LoginPageVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("i18n")
public class I18nController {

    @RequestMapping("get")
    public LoginPageVo get() {
        LoginPageVo loginPageVo = new LoginPageVo();

        loginPageVo.setTitle(MessageUtil.get("title"));
        loginPageVo.setUsername(MessageUtil.get("username"));
        loginPageVo.setPassword(MessageUtil.get("password"));
        loginPageVo.setWelcome(MessageUtil.get("welcome"));
        loginPageVo.setRememberMe(MessageUtil.get("rememberMe"));
        loginPageVo.setLogin(MessageUtil.get("login"));

        return loginPageVo;
    }


}
