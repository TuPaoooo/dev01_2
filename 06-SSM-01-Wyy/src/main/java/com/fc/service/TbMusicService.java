package com.fc.service;

import com.fc.entity.TbMusic;

import java.util.List;

public interface TbMusicService {
    //查询歌单
    List<TbMusic> findAll();

    //播放单个歌曲
    TbMusic findById(Integer musicId);

    //播放上一首
    TbMusic prevSong(Integer musicId);

    //播放下一首
    TbMusic nextSong(Integer musicId);

    //搜索歌
    List<TbMusic> search(String keyword);


}
