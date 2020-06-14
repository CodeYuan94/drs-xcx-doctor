package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.PastHistoryDao;
import com.df.drs.model.entity.PastHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 既往史dao实现
 * @date 2020/6/3 15:06
 **/
@Repository
public class PastHistoryDaoImpl extends BaseDao implements PastHistoryDao {

    public PastHistoryDaoImpl() {
        this.url = "com.df.drs.dao.PastHistoryDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            return -1;
        }
        return this.getSqlSession().update(url+"deleteByPrimaryKey",id);
    }

    @Override
    public int insert(PastHistory record) {
        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(PastHistory record) {
        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public PastHistory selectByPrimaryKey(String id) {
        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }

    @Override
    public List<PastHistory> selectByPatientId(String id) {
        if (StringUtils.isNullOrEmpty(id)) {
            return null;
        }
        return this.getSqlSession().selectList(url+"selectByPatientId",id);
    }

    @Override
    public int updateByPrimaryKeySelective(PastHistory record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(PastHistory record) {
        if (null == record || null == record.getId()) {
            return -1;
        }
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
