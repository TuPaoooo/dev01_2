package com.fc.controller;

import com.fc.dao.LiveMapper;
import com.fc.entity.Live;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("live")
public class LiveController {

    @Autowired
    private LiveMapper liveMapper;

    //返回查询到的对象集合
    @GetMapping("findAll")
    public List<Live> findAll(){
        List<Live> lives = liveMapper.selectByExample(null);
        return lives;
    }

    //删除
    @PostMapping("delete")
    public void delete(String id){
        liveMapper.deleteByPrimaryKey(id);
    }

    //addOrUpdate
    @PostMapping("addOrUpdate")
    public void addOrUpdate(@RequestBody Live live){
        if(live.getId()==null){
            //、无id进行添加操作,需要生成随机唯一id，添加创建时间

            //随机生成的id
            String uuid =UUID.randomUUID().toString().trim().replaceAll("-","");
            live.setId(uuid);
            live.setCreateTime(new Date());
            liveMapper.insertSelective(live);
        }else {
            liveMapper.updateByPrimaryKeySelective(live);
        }
    }



}
