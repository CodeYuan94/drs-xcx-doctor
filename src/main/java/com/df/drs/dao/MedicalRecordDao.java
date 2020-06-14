package com.df.drs.dao;


import com.df.drs.model.dto.patient.MedicalRecordDTO;
import com.df.drs.model.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordDao {
    int deleteByPrimaryKey(String id);

    int insert(MedicalRecord record);

    int insertSelective(MedicalRecord record);

    MedicalRecord selectByPrimaryKey(String id);

    /**
     * 查询患者的就诊履历
     * @param patientId
     * @return
     */
    List<MedicalRecordDTO> selectByPatientId(String patientId);

    int updateByPrimaryKeySelective(MedicalRecord record);

    int updateByPrimaryKey(MedicalRecord record);
}