package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.patient.PatientDTO;

/**
 * @author yuan
 * @project drs
 * @description 患者个人资料服务接口
 * @date 2020/6/4 9:25
 **/
public interface PatientInfoService {

    /**
     * 通过id查找患者个人资料
     * @param id
     * @return
     */
    ResultBean<PatientDTO> findPatientById(String id);

    /**
     * 保存患者个人信息
     * @param patientDTO
     * @param username
     * @return
     */
    ResultBean savePatientInfo(PatientDTO patientDTO, String username);

}
