package com.fc.service;

import com.fc.entity.Collection;
import com.fc.vo.ResultVO;

public interface CollectService {

    //添加收藏
    ResultVO add(Collection collection);

    //删除收藏
    ResultVO delete(Long id);

    //获取收藏
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);
}
