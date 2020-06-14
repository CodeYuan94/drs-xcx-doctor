package com.df.drs.dao;


import com.df.drs.model.entity.PastHistory;

import java.util.List;

public interface PastHistoryDao {
    int deleteByPrimaryKey(String id);

    int insert(PastHistory record);

    int insertSelective(PastHistory record);

    PastHistory selectByPrimaryKey(String id);

    List<PastHistory> selectByPatientId(String id);

    int updateByPrimaryKeySelective(PastHistory record);

    int updateByPrimaryKey(PastHistory record);
}