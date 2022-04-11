package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectionMapper collectionMapper;

    //添加收藏
    @Override
    public ResultVO add(Collection collection) {
        //如果创建时间为空就创建一个
        if (collection.getCreateTime() == null) {
            collection.setCreateTime(new Date());
        }

        int affectedRows = collectionMapper.insertSelective(collection);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, collection);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }

    //删除收藏
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = collectionMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;

        if (affectedRows > 0) {
            resultVO = new ResultVO(200, "成功", true, null);
        } else {
            resultVO = new ResultVO(-1, "失败", false, null);
        }
        return null;
    }


    //获取收藏
    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, Long id) {

        List<Collection> collections;

        ResultVO resultVO;

        try {
            if (id != null) {
                //传了id，就获取单个
                Collection collection = collectionMapper.selectByPrimaryKey(id);
                //新建一个集合
                collections = new ArrayList<>();
                //把单个给放进去，因为一会要输出
                collections.add(collection);
            } else {
                //开启分页
                PageHelper.startPage(pageNum, pageSize);
                //不传id，就获取全部
                collections = collectionMapper.selectByExample(null);
            }
            //分页信息
            PageInfo<Collection> pageInfo = new PageInfo<>(collections);
            //输出的数据
            DataVO<Collection> dataVO = new DataVO<>(pageInfo.getTotal(), collections, pageSize, pageNum);

            resultVO = new ResultVO(200, "成功", true, dataVO);

        } catch (Exception e) {
            resultVO = new ResultVO(-1, "失败", false, null);
        }

        return resultVO;
    }
}
