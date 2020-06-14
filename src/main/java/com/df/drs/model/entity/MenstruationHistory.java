package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * menstruation_history
 * @author 
 */
@Data
public class MenstruationHistory implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 初潮
     */
    private Integer menarche;

    /**
     * 经量
     */
    private Integer mensAmount;

    /**
     * 痛经程度
     */
    private Integer dysmenorrhea;

    /**
     * 性交痛
     */
    private Integer coitalPain;

    /**
     * 末次月经首日
     */
    private Date lastMensFirstDay;

    /**
     * 月经周期min
     */
    private Integer mensCycleMin;

    /**
     * 月经周期max
     */
    private Integer mensCycleMax;

    /**
     * 经期min
     */
    private Integer mensPeriodMin;

    /**
     * 经期max
     */
    private Integer mensPeriodMax;

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
     * 患者资料
     */
    private String patientId;

    private static final long serialVersionUID = 1L;
}