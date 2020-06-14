package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * past_history
 * @author 
 */
@Data
public class PastHistory implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 用户id
     */
    private String patientId;

    /**
     * 男女标志
     */
    private Integer gender;

    /**
     * 肝炎
     */
    private Integer hepatitis;

    /**
     * 结核
     */
    private Integer tuberculosis;

    /**
     * 肾脏疾病
     */
    private Integer kidneyDisease;

    /**
     * 心血管疾病
     */
    private Integer cardiovascularDisease;

    /**
     * 尿路系感染
     */
    private Integer urinaryTractInfection;

    /**
     * 性传播疾病史
     */
    private Integer sexuallyTransmittedDiseaseHistory;

    /**
     * 阑尾炎
     */
    private Integer appendicitis;

    /**
     * 盆腔炎
     */
    private Integer pelvicInfection;

    /**
     * 其他疾病
     */
    private String remarks;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改者
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 删除标记
     */
    private Integer delflag;

    private static final long serialVersionUID = 1L;
}