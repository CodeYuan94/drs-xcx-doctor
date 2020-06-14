package com.df.drs.dao;


import com.df.drs.model.entity.FamilyHistory;

import java.util.List;

public interface FamilyHistoryDao {
    int deleteByPrimaryKey(String id);

    int batchDelete(List<Long> ids);

    int insert(FamilyHistory record);

    int insertSelective(FamilyHistory record);

    FamilyHistory selectByPrimaryKey(String id);

    List<FamilyHistory> selectByPatientId(String patientId);

    int updateByPrimaryKeySelective(FamilyHistory record);

    int updateByPrimaryKey(FamilyHistory record);
}