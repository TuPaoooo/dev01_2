package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    //登录
    @Override
    public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        //使用username和password进行登录，查询数据库
        criteria.andUsernameEqualTo(req.getParameter("username"));
        criteria.andPasswordEqualTo(req.getParameter("password"));
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);

        ModelAndView mv = new ModelAndView();


        return null;
    }



}
