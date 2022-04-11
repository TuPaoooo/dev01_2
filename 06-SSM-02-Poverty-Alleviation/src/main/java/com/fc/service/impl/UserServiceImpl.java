package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //如果传id就查询单个，不传id就查询全部
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {
        List<User> users;

        ResultVO resultVO;
        try {
            if (id != null) {
                //单个学生
                User user = userMapper.selectByPrimaryKey(id);
                users = new ArrayList<>();
                users.add(user);
            } else {
                //开启分页
                PageHelper.startPage(pageNum, pageSize);

                users = userMapper.selectByExample(null);
            }

            //分页信息
            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVO<User> dataVO = new DataVO<>(pageInfo.getTotal(), users, pageNum, pageSize);

            resultVO = new ResultVO(200, "成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVO(-1, "失败", false, null);

        }

        return resultVO;
    }

    //添加用户
    @Override
    public ResultVO add(User user) {

        //如果用户的创建时间为空就给新建一个当前时间
        if (user.getCreateTime() == null) {
            user.setCreateTime(new Date());
        }
        //设置一下主键回填
        int affectedRows = userMapper.insertSelective(user);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, user);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //修改用户信息
    @Override
    public ResultVO update(User user) {
        int affectedRows = userMapper.updateByPrimaryKeySelective(user);

        ResultVO resultVO;

        if (affectedRows > 0) {

            User result = userMapper.selectByPrimaryKey(user.getId());

            resultVO = new ResultVO(200, "成功", true, result);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }


        return resultVO;
    }

    //删除用户
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = userMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }
}
