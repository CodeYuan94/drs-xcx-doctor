package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.patient.PatientLabelConfigDTO;
import com.df.drs.model.dto.patient.PatientLabelDTO;

/**
 * @author yuan
 * @project drs
 * @description 患者标签服务接口
 * @date 2020/6/5 11:00
 **/
public interface PatientLabelService {

    /**
     * 通过patientId查找标签名
     * @param patientId
     * @return
     */
    ResultBean<PatientLabelConfigDTO> findNameByPatientId(String patientId);

    /**
     * 通过patientId查找标签id
     * @param patientId
     * @return
     */
    ResultBean<PatientLabelDTO> findIdByPatientId(String patientId);

    /**
     * 查出所有的患者标签
     * @return
     */
    ResultBean<PatientLabelConfigDTO> findAllPatientLabel();
}
