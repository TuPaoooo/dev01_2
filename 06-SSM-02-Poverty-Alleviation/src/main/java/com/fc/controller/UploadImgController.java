//package com.fc.controller;
//
//import com.fc.vo.ResultVO;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.WebResource;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.UUID;
//
//@RestController
//@RequestMapping
//public class UploadImgController {
//
//    @RequestMapping("uploadImg")
//    public ResultVO testCrossDomainUpload(MultipartFile file) {
//        // 准备文件上传的路径
//        String path = "http://localhost:8081/upload/";
//
//        // 获取文件名
//        String filename = file.getOriginalFilename();
//
//        //把文件的名称设置成唯一值，uuid
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//        filename = uuid + "-" + filename;
//
//        // 创建客户端对象
//        Client client = Client.create();
//
//        // 连接到图片服务器
//        WebResource resource = client.resource(path + filename);
//
//        try {
//            // 上传文件
//            resource.put(file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String url = path + filename;
//        HashMap<String, Object> map = new HashMap<>();
//
//        map.put("imgurl", url);
//
//        return new ResultVO(200, "Ok", true, map);
//    }
//
//}
