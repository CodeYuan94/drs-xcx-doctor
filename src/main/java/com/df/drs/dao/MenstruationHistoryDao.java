package com.df.drs.dao;


import com.df.drs.model.entity.MenstruationHistory;

import java.util.List;

public interface MenstruationHistoryDao {
    int deleteByPrimaryKey(String id);

    int insert(MenstruationHistory record);

    int insertSelective(MenstruationHistory record);

    MenstruationHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MenstruationHistory record);

    int updateByPrimaryKey(MenstruationHistory record);

    List<MenstruationHistory> selectByPatientId(String patientId);
}