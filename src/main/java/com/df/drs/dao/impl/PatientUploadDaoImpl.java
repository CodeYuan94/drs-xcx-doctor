package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.PatientUploadDao;
import com.df.drs.model.entity.PatientUpload;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author yuan
 * @project drs
 * @description 患者上传资料dao实现
 * @date 2020/6/3 15:09
 **/
@Repository
public class PatientUploadDaoImpl extends BaseDao implements PatientUploadDao {

    public PatientUploadDaoImpl() {
        super();
       url = "com.df.drs.dao.PatientUploadDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey",id);
    }

    @Override
    public int insert(PatientUpload record) {
        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(PatientUpload record) {
        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public PatientUpload selectByPrimaryKey(String id) {
        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }

    @Override
    public List<PatientUpload> selectByPatientId(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectByPatientId",patientId);
    }

    @Override
    public int updateByPrimaryKeySelective(PatientUpload record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(PatientUpload record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
