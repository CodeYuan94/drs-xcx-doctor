package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.dao.HospitalDao;
import com.df.drs.model.entity.Hospital;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 医院dao实现
 * @date 2020/6/9 18:58
 **/
@Repository
public class HospitalDaoImpl extends BaseDao implements HospitalDao {

    public HospitalDaoImpl () {
        this.url = "com.df.drs.dao.HospitalDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Hospital record) {
        return 0;
    }

    @Override
    public int insertSelective(Hospital record) {
        return 0;
    }

    @Override
    public Hospital selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Hospital record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Hospital record) {
        return 0;
    }

    @Override
    public List<Hospital> selectAll() {
        return this.getSqlSession().selectList(url+"selectAll");
    }
}
