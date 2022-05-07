package com.fc.dao;

import com.fc.entity.Building;
import com.fc.entity.BuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildingMapper {
    long countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);

    int deleteByPrimaryKey(String id);

    int insert(Building record);

    int insertSelective(Building record);

    List<Building> selectByExample(BuildingExample example);

    Building selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByExample(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
}