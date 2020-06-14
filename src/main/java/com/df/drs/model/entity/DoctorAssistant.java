package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * doctor_assistant
 * @author 
 */
@Data
public class DoctorAssistant implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 助理名字
     */
    private String name;

    /**
     * 头像地址
     */
    private String photoUrl;

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