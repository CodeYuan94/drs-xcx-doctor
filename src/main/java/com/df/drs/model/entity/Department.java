package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * department
 * @author 
 */
@Data
public class Department implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 科室名
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 删除标记
     */
    private Integer delflag;

    private static final long serialVersionUID = 1L;
}