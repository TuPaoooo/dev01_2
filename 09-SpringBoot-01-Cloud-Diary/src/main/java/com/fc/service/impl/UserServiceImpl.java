package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper tbUserDao;

    //登录
    @Override
    public ResultVo login(String username, String password) {
        ResultVo resultVo;

        TbUserExample example = new TbUserExample();

        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbUser> users = tbUserDao.selectByExample(example);

        if (users.size() > 0) {
            resultVo = new ResultVo(200, "登陆成功", true, users.get(0));
        } else {
            resultVo = new ResultVo(0, "登陆失败,用户名或密码错误", false, null);
        }

        return resultVo;
    }

    //退出登录
    @Override
    public ModelAndView logout(HttpSession session, HttpServletResponse response, HttpServletRequest request, ModelAndView mv) {
        //销毁Session对象
        session = request.getSession(false);
        session.removeAttribute("user");
        session.removeAttribute("dataInfo");
        session.removeAttribute("typeInfo");

        //清空Cookie对象过期时间
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        //重定向跳转到login.jsp登录页面
        mv.setViewName("redirect:/login.jsp");
        return mv;
    }

    //进入个人中心
    @Override
    public ModelAndView userCenter(HttpServletRequest request,
                                   HttpServletResponse response,
                                   ModelAndView mv) {

        //设置请求域对象menu_page的值为user
        mv.addObject("menu_page", "user");
        //设置请求域对象changePage的值为user目录下的info.jsp
        mv.addObject("changePage", "user/info.jsp");

        //转发至index.jsp页面
        mv.setViewName("redirect:/index.jsp");

        return mv;
    }

    //修改用户信息
    @Override
    public ModelAndView update(MultipartFile img, HttpServletRequest request, TbUser user) {

        HttpSession session = request.getSession();

        if (img.getSize() > 0) {
            String path = "D:\\idea_code\\dev01_2\\09-SpringBoot-01-Cloud-Diary\\src\\main\\resources\\META-INF\\resources\\upload";

            File file = new File(path);

            String filename = img.getOriginalFilename();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");

            String formatDate = formatter.format(new Date());

            String suffix = null;

            if (filename != null) {
                suffix = filename.substring(filename.lastIndexOf("."));
            }

            filename = formatDate + suffix;

            try {
                img.transferTo(new File(file, filename));

                user.setHead(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //更新
        tbUserDao.updateByPrimaryKeySelective(user);

        //根据id获取用户
        TbUser tbUser = tbUserDao.selectByPrimaryKey(user.getId());

        session.setAttribute("user", tbUser);

        //转发执行user/userCenter接口
        ModelAndView mv = new ModelAndView("redirect:/user/userCenter");

        return mv;
    }




}
