package com.fc.controller;

import com.fc.entity.TbMusic;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("music")
public class TbMusicController {
    @Autowired
    private TbMusicService tbMusicService;

    //查询歌单
    @RequestMapping("findAll")
    public List<TbMusic> findAll() {
        System.out.println(123);
        return tbMusicService.findAll();

    }

    //播放单个歌曲
    @RequestMapping("findById")
    public TbMusic findById(Integer musicId) {
        return tbMusicService.findById(musicId);
    }

    //播放上一首
    @RequestMapping("prevSong")
    public TbMusic prevSong(Integer musicId) {
        return tbMusicService.prevSong(musicId);
    }

    //播放下一首
    @RequestMapping("nextSong")
    public TbMusic nextSong(Integer musicId) {
        return tbMusicService.nextSong(musicId);
    }

    //搜索歌
    @RequestMapping("search")
    public List<TbMusic> search(String keyword) {
        return tbMusicService.search(keyword);
    }

}
