package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("upload")
    public ModelAndView upload(MultipartFile upload, ModelAndView mv) {
        //准备路径
        String path = "D:/apache-tomcat-8.5.37/webapps/upload";

        File file = new File(path);

        //合法性判断，万一路径不存在就新建
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取文件名
        String filename = upload.getOriginalFilename();


        if (filename != null) {
            //上传
            try {
                upload.transferTo(new File(path, filename));

                mv.addObject("img", "http://localhost:8081/upload/" + filename);

                mv.setViewName("/success.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mv;
    }
}
