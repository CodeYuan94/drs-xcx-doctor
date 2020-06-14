package com.df.drs.dao;


import com.df.drs.model.entity.Department;

import java.util.List;

public interface DepartmentDao {
    int deleteByPrimaryKey(String id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String id);

    /**
     * 查询所有部门
     * @return
     */
    List<Department> selectAll();

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}