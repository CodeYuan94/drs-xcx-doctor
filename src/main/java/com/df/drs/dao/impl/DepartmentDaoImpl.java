package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.dao.DepartmentDao;
import com.df.drs.model.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author yuan
 * @project drs
 * @description 部门dao实现
 * @date 2020/6/10 9:15
 **/
@Repository
public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {

    public DepartmentDaoImpl() {
        this.url = "com.df.drs.dao.DepartmentDao.";
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public Department selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public List<Department> selectAll() {
        return this.getSqlSession().selectList(url+"selectAll");
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }
}
