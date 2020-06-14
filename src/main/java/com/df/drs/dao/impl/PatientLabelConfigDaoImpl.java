package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.dao.PatientLabelConfigDao;
import com.df.drs.model.entity.PatientLabelConfig;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author yuan
 * @project drs
 * @description 患者标签配置dao实现
 * @date 2020/6/5 11:24
 **/
@Repository
public class PatientLabelConfigDaoImpl extends BaseDao implements PatientLabelConfigDao {

    public PatientLabelConfigDaoImpl () {
        this.url = "com.df.drs.dao.PatientLabelConfigDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(PatientLabelConfig record) {
        return 0;
    }

    @Override
    public int insertSelective(PatientLabelConfig record) {
        return 0;
    }

    @Override
    public PatientLabelConfig selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public List<PatientLabelConfig> selectAllLabel() {
        return this.getSqlSession().selectList(url+"selectAllLabel");
    }

    @Override
    public int updateByPrimaryKeySelective(PatientLabelConfig record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PatientLabelConfig record) {
        return 0;
    }
}
