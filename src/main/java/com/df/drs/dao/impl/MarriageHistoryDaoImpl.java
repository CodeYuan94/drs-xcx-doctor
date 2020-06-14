package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.MarriageHistoryDao;
import com.df.drs.model.entity.MarriageHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 婚育史dao实现
 * @date 2020/6/3 14:47
 **/
@Repository
public class MarriageHistoryDaoImpl extends BaseDao implements MarriageHistoryDao {

    public MarriageHistoryDaoImpl() {
        this.url = "com.df.drs.dao.MarriageHistoryDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey",id);
    }

    @Override
    public int insert(MarriageHistory record) {
        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(MarriageHistory record) {
        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public MarriageHistory selectByPrimaryKey(String id) {
        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }

    @Override
    public List<MarriageHistory> selectByPatientId(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectByPatientId",patientId);
    }

    @Override
    public int updateByPrimaryKeySelective(MarriageHistory record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(MarriageHistory record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
