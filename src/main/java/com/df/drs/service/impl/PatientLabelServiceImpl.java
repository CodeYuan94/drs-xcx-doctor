package com.df.drs.service.impl;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.dao.PatientLabelConfigDao;
import com.df.drs.dao.PatientLabelDao;
import com.df.drs.model.dto.patient.PatientLabelConfigDTO;
import com.df.drs.model.dto.patient.PatientLabelDTO;
import com.df.drs.model.entity.PatientLabelConfig;
import com.df.drs.service.PatientLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author yuan
 * @project drs
 * @description 患者标签服务实现
 * @date 2020/6/5 11:22
 **/
@Service
public class PatientLabelServiceImpl implements PatientLabelService {

    @Autowired
    private PatientLabelDao patientLabelDao;

    @Autowired
    private PatientLabelConfigDao patientLabelConfigDao;


    @Override
    public ResultBean<PatientLabelConfigDTO> findNameByPatientId(String patientId) {
        List<PatientLabelConfigDTO> patientLabelConfigDTOS = patientLabelDao.selectNameByPatientId(patientId);
        if (null == patientLabelConfigDTOS || patientLabelConfigDTOS.isEmpty()) {
            return ResultBean.success("查询成功，数据为空！",null);
        } else {
            return ResultBean.success("查询成功！",patientLabelConfigDTOS);
        }
    }

    @Override
    public ResultBean<PatientLabelDTO> findIdByPatientId(String patientId) {
        return null;
    }

    @Override
    public ResultBean<PatientLabelConfigDTO> findAllPatientLabel() {
        List<PatientLabelConfig> patientLabelConfigs = patientLabelConfigDao.selectAllLabel();
        if (null == patientLabelConfigs || patientLabelConfigs.isEmpty()) {
            return ResultBean.success("查询成功，数据为空！",null);
        } else {
            List<PatientLabelConfigDTO> patientLabelConfigDTOS = CopyClassUtils.copyListProperties(patientLabelConfigs,PatientLabelConfigDTO.class);
            return ResultBean.success("查询成功！",patientLabelConfigDTOS);
        }
    }
}
