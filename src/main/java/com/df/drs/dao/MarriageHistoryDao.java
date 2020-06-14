package com.df.drs.dao;


import com.df.drs.model.entity.MarriageHistory;

import java.util.List;

public interface MarriageHistoryDao {
    int deleteByPrimaryKey(String id);

    int insert(MarriageHistory record);

    int insertSelective(MarriageHistory record);

    MarriageHistory selectByPrimaryKey(String id);

    List<MarriageHistory> selectByPatientId(String patientId);

    int updateByPrimaryKeySelective(MarriageHistory record);

    int updateByPrimaryKey(MarriageHistory record);
}