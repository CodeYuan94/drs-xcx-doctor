package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.MedicalRecordDao;
import com.df.drs.model.dto.patient.MedicalRecordDTO;
import com.df.drs.model.entity.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 就诊履历dao实现
 * @date 2020/6/10 17:36
 **/
@Repository
public class MedicalRecordDaoImpl extends BaseDao implements MedicalRecordDao {

    public MedicalRecordDaoImpl() {
        this.url = "com.df.drs.dao.MedicalRecordDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(MedicalRecord record) {
        return 0;
    }

    @Override
    public int insertSelective(MedicalRecord record) {
        return 0;
    }

    @Override
    public MedicalRecord selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public List<MedicalRecordDTO> selectByPatientId(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectByPatientId");
    }

    @Override
    public int updateByPrimaryKeySelective(MedicalRecord record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(MedicalRecord record) {
        return 0;
    }
}
