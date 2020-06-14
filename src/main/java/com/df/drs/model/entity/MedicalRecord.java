package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * medical_record
 * @author 
 */
@Data
public class MedicalRecord implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 患者id
     */
    private String patientId;

    /**
     * 医生id
     */
    private String doctorId;

    /**
     * 助理id
     */
    private String assistantId;

    /**
     * 就诊时间
     */
    private Date consultationTime;

    /**
     * 就诊阶段
     */
    private Integer consultationStage;

    /**
     * 就诊内容
     */
    private String consultationContent;

    /**
     * 处理意见
     */
    private String handleOpinion;

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