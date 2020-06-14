package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * family_history
 * @author 
 */
@Data
public class FamilyHistory implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 患者id
     */
    private String patientId;

    /**
     * 男女方 （标记）
     */
    private Integer gender;

    /**
     * 家族成员
     */
    private String familyMember;

    /**
     * 染色体平衡移位（标记）
     */
    private Integer chromosomalBalancedTranslocation;

    /**
     * 单基因病（标记）
     */
    private Integer monogenicDisease;

    /**
     * 染色体异常（标记）
     */
    private Integer chromosomeAbnormalities;

    /**
     * 不孕病史（标记）
     */
    private Integer infertilityHistory;

    /**
     * 详情
     */
    private String detail;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标记
     */
    private Integer delflag;

    private static final long serialVersionUID = 1L;
}