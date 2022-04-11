package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collection")
public class CollectController {
    @Autowired
    private CollectService collectService;

    //添加收藏
    @PostMapping("add")
    public ResultVO add(Collection collection){
        return collectService.add(collection);
    }

    //删除收藏
    @GetMapping("delete")
    public ResultVO delete(Long id){
        return collectService.delete(id);
    }

    //获取收藏
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize,
                            Long id){
        return collectService.getList(pageNum,pageSize,id);
    }
}
