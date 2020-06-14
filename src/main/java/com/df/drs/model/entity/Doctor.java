package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * doctor 医生
 * @author 
 */
@Data
public class Doctor implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 助理id
     */
    private String assistantId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 所属医院
     */
    private String hospitalId;

    /**
     * 科室
     */
    private String departmentId;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 头像
     */
    private String photoUrl;

    /**
     * 职称
     */
    private String positionalTitle;

    /**
     * 手机号
     */
    private String phone;

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