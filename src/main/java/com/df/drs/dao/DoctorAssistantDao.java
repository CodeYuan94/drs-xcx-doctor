package com.df.drs.dao;


import com.df.drs.model.entity.DoctorAssistant;

public interface DoctorAssistantDao {
    int deleteByPrimaryKey(String id);

    int insert(DoctorAssistant record);

    int insertSelective(DoctorAssistant record);

    DoctorAssistant selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DoctorAssistant record);

    int updateByPrimaryKey(DoctorAssistant record);
}