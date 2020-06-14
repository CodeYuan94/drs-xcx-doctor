package com.df.drs.dao;


import com.df.drs.model.entity.PatientUpload;

import java.util.List;

public interface PatientUploadDao {
    int deleteByPrimaryKey(String id);

    int insert(PatientUpload record);

    int insertSelective(PatientUpload record);

    PatientUpload selectByPrimaryKey(String id);

    List<PatientUpload> selectByPatientId(String patientId);

    int updateByPrimaryKeySelective(PatientUpload record);

    int updateByPrimaryKey(PatientUpload record);
}