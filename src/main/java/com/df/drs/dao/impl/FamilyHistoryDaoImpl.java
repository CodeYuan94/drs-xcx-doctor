package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.FamilyHistoryDao;
import com.df.drs.model.entity.FamilyHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FamilyHistoryDaoImpl extends BaseDao implements FamilyHistoryDao {

    public FamilyHistoryDaoImpl(){
        this.url = "com.df.drs.dao.FamilyHistoryDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {

        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey",id);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        return this.getSqlSession().update(url+"batchDelete",ids);
    }

    @Override
    public int insert(FamilyHistory record) {

        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(FamilyHistory record) {

        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public FamilyHistory selectByPrimaryKey(String id) {
        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }

    @Override
    public List<FamilyHistory> selectByPatientId(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectByPatientId",patientId);
    }

    @Override
    public int updateByPrimaryKeySelective(FamilyHistory record) {

        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(FamilyHistory record) {

        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
