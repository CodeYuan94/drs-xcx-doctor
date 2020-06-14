package com.df.drs.dao;


import com.df.drs.model.entity.Platform;

public interface PlatformDao {
    int deleteByPrimaryKey(String id);

    int insert(Platform record);

    int insertSelective(Platform record);

    Platform selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Platform record);

    int updateByPrimaryKey(Platform record);
}