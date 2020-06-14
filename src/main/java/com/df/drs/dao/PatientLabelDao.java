package com.df.drs.dao;


import com.df.drs.model.dto.patient.PatientLabelConfigDTO;
import com.df.drs.model.dto.patient.PatientLabelDTO;
import com.df.drs.model.entity.PatientLabel;

import java.util.List;

public interface PatientLabelDao {
    int deleteByPrimaryKey(String id);

    int insert(PatientLabel record);

    int insertSelective(PatientLabel record);

    PatientLabel selectByPrimaryKey(String id);

    /**
     * 查找患者对应的标签id
     * @param patientId
     * @return
     */
    List<PatientLabelDTO> selectIdByPatientId(String patientId);

    /**
     * 查找患者对应的标签名
     * @param patientId
     * @return
     */
    List<PatientLabelConfigDTO> selectNameByPatientId(String patientId);

    int updateByPrimaryKeySelective(PatientLabel record);

    int updateByPrimaryKey(PatientLabel record);
}