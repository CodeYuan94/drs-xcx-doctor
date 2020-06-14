package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.patient.MedicalRecordDTO;
import com.df.drs.model.dto.patient.PatientCardDTO;

/**
 * @author yuan
 * @project drs
 * @description 患者名片service接口
 * @date 2020/6/3 9:02
 **/
public interface PatientCardService {

    /**
     * 查看患者个人资料
     * @param patientId
     * @return
     */
    ResultBean<PatientCardDTO> findPatientInfo(String patientId);

    /**
     * 查看患者就诊履历
     * @param patientId
     * @return
     */
    ResultBean<MedicalRecordDTO> findMedicalRecord(String patientId);
}
