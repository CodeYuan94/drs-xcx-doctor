package com.df.drs.dao;


import com.df.drs.model.entity.Hospital;

import java.util.List;

public interface HospitalDao {
    int deleteByPrimaryKey(String id);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);

    /**
     * 查询所有的医院
     * @return
     */
    List<Hospital> selectAll();
}