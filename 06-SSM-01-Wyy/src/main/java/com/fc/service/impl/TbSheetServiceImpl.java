package com.fc.service.impl;

import com.fc.dao.TbSheetMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbSheetServiceImpl implements TbSheetService {
    @Autowired
    private TbSheetMapper tbSheetMapper;

    //查看歌单
    @Override
    public List<TbSheet> findAll() {

        return tbSheetMapper.selectByExample(null);
    }

    //插入歌单
    @Override
    public int insertSheet(TbSheet tbSheet) {
        return tbSheetMapper.insertSelective(tbSheet);
    }

    //查看歌单的歌曲
    @Override
    public List<TbMusic> findSongsBySheet(String sheetName) {
        return tbSheetMapper.findSongsBySheet(sheetName);
    }


}
