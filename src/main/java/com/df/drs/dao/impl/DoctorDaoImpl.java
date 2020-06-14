package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.DoctorDao;
import com.df.drs.model.entity.Doctor;
import org.springframework.stereotype.Repository;

/**
 * @author yuan
 * @project drs
 * @description 医生Dao实现
 * @date 2020/6/2 16:13
 **/
@Repository
public class DoctorDaoImpl extends BaseDao implements DoctorDao {

    public DoctorDaoImpl() {
        this.url = "com.df.drs.dao.DoctorDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Doctor record) {

        return this.getSqlSession().insert(url+"insert", record);
    }

    @Override
    public int insertSelective(Doctor record) {

        return this.getSqlSession().insert(url+"insertSelective", record);
    }

    @Override
    public Doctor selectByPrimaryKey(String id) {

        return this.getSqlSession().selectOne(url+"selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Doctor record) {

        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(Doctor record) {

        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
