package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public Boolean login(TbUser user) {
        TbUser selectUser = tbUserMapper.selectUser(user.getUsername(), user.getPassword());

        if(selectUser!=null){
            return true;
        }else {
            return false;
        }
    }

    //登录
//    @Override
//    public Boolean login(String username, String password) {
//        ResultVO resultVO = null;
//
//        if(username==null||password==null){
//            resultVO.setCode(0);
//            resultVO.setMessage("用户名或密码不可为空");
//            return resultVO;
//        }
//
//        TbUser user = tbUserMapper.selectUser(username, password);
//
//        if(user!=null){
//
//
//        }
//        return null;
//    }

}
