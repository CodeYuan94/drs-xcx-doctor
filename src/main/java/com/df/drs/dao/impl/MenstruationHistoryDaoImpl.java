package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.MenstruationHistoryDao;
import com.df.drs.model.entity.MenstruationHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 月经史dao实现
 * @date 2020/6/3 14:51
 **/
@Repository
public class MenstruationHistoryDaoImpl extends BaseDao implements MenstruationHistoryDao {

    public MenstruationHistoryDaoImpl() {
        this.url = "com.df.drs.dao.MenstruationHistoryDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey",id);
    }

    @Override
    public int insert(MenstruationHistory record) {
        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(MenstruationHistory record) {
        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public MenstruationHistory selectByPrimaryKey(String id) {
        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(MenstruationHistory record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(MenstruationHistory record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }

    @Override
    public List<MenstruationHistory> selectByPatientId(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectByPatientId",patientId);
    }
}
