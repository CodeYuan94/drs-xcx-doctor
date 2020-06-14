package com.df.drs.dao;


import com.df.drs.model.entity.Patient;

public interface PatientDao {
    int deleteByPrimaryKey(String id);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}