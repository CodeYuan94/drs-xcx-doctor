package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.PatientLabelDao;
import com.df.drs.model.dto.patient.PatientLabelConfigDTO;
import com.df.drs.model.dto.patient.PatientLabelDTO;
import com.df.drs.model.entity.PatientLabel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 患者标签dao实现
 * @date 2020/6/3 11:25
 **/
@Repository
public class PatientLabelDaoImpl extends BaseDao implements PatientLabelDao {

    public PatientLabelDaoImpl() {
        this.url = "com.df.drs.dao.PatientLabelDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey",id);
    }

    @Override
    public int insert(PatientLabel record) {
        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(PatientLabel record) {
        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public PatientLabel selectByPrimaryKey(String id) {
        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }

    @Override
    public List<PatientLabelDTO> selectIdByPatientId(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectIdByPatientId",patientId);
    }

    @Override
    public List<PatientLabelConfigDTO> selectNameByPatientId(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectNameByPatientId",patientId);
    }


    @Override
    public int updateByPrimaryKeySelective(PatientLabel record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(PatientLabel record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
