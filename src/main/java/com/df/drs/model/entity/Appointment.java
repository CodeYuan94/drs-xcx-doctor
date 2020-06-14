package com.df.drs.model.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * appointment  预约
 * @author  Liu
 * @date  2020年6月2日14:32:57
 */
@Data
public class Appointment implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 患者id
     */
    private String patientId;

    /**
     * 预约类型
     */
    private String type;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 提醒时间
     */
    private Time remindTime;
    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 预约时间
     */
    private Date appointmentTime;

    /**
     * 是否全天
     */
    private Integer fullDay;

    /**
     * 备注
     */
    private String remarks;

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

    /**
     * 完成标记
     */
    private Integer completed;

    /**
     * 过期标记
     */
    private Integer expired;

    private static final long serialVersionUID = 1L;


}