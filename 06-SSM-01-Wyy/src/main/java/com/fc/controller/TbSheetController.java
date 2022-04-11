package com.fc.controller;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sheet")
public class TbSheetController {
    @Autowired
    private TbSheetService tbSheetService;

    //查看所有歌单
    @RequestMapping("findAll")
    public List<TbSheet> findAll() {
        return tbSheetService.findAll();
    }

    //查看歌单的歌曲
    @RequestMapping("findSongsBySheet")
    public List<TbMusic> findSongsBySheet(String sheetName){
        return tbSheetService.findSongsBySheet(sheetName);
    }

    //插入歌单
    @RequestMapping("insertSheet")
    public Map<String, Object> insertSheet(TbSheet tbSheet) {
        int affectedRows = tbSheetService.insertSheet(tbSheet);

        Map<String, Object> map = new HashMap<>();

        if (affectedRows > 0) {
            map.put("code", 200);
        } else {
            map.put("code", -1);
        }

        return map;
    }
}

