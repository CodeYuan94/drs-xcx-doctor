package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.PatientDao;
import com.df.drs.model.entity.Patient;
import org.springframework.stereotype.Repository;

/**
 * @author yuan
 * @project drs
 * @description 患者DaoImpl
 * @date 2020/6/2 14:57
 **/
@Repository
public class PatientDaoImpl extends BaseDao implements PatientDao {

    public PatientDaoImpl() {
        this.url = "com.df.drs.dao.PatientDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {

        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey",id);
    }

    @Override
    public int insert(Patient record) {
        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(Patient record) {

        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public Patient selectByPrimaryKey(String id) {

        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(Patient record) {

        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Patient record) {

        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
