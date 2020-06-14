package com.df.drs.dao;


import com.df.drs.model.entity.Doctor;

public interface DoctorDao {
    int deleteByPrimaryKey(String id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);


}