package com.fc.service;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;

import java.util.List;

public interface TbSheetService {


    //查看歌单
    List<TbSheet> findAll();

    //插入歌单
    int insertSheet(TbSheet tbSheet);

    List<TbMusic> findSongsBySheet(String sheetName);
}
