package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.dao.PatientDao;
import com.df.drs.model.dto.patient.PatientDTO;
import com.df.drs.model.entity.Patient;
import com.df.drs.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yuan
 * @project drs
 * @description 患者个人资料服务实现
 * @date 2020/6/4 9:46
 **/
@Service
public class PatientInfoServiceImpl implements PatientInfoService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public ResultBean<PatientDTO> findPatientById(String id) {
        Patient patient = patientDao.selectByPrimaryKey(id);
        if (null == patient) {
            return ResultBean.success("查询成功，数据为空！",null);
        } else {
            PatientDTO patientDTO = CopyClassUtils.copyClassProperties(patient,PatientDTO.class);
            return ResultBean.success("查询成功！",patientDTO);
        }
    }

    @Override
    public ResultBean savePatientInfo(PatientDTO patientDTO, String username) {
        // 由于患者登录时已插入一张个人信息表 保存即更新
        // 更新个人资料
        Patient patient = CopyClassUtils.copyClassProperties(patientDTO,Patient.class);
        patient.setUpdateTime(new Date());
        patient.setUpdateUser(username);
        int update = patientDao.updateByPrimaryKeySelective(patient);
        if (update > 0) {
            return ResultBean.success("保存成功！");
        }
        return ResultBean.error(ErrorCode.SAVE_ERROR,"保存失败！");
    }
}
