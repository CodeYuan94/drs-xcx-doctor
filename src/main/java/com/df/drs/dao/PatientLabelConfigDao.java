package com.df.drs.dao;


import com.df.drs.model.entity.PatientLabelConfig;

import java.util.List;

public interface PatientLabelConfigDao {
    int deleteByPrimaryKey(String id);

    int insert(PatientLabelConfig record);

    int insertSelective(PatientLabelConfig record);

    PatientLabelConfig selectByPrimaryKey(String id);

    List<PatientLabelConfig> selectAllLabel();

    int updateByPrimaryKeySelective(PatientLabelConfig record);

    int updateByPrimaryKey(PatientLabelConfig record);
}