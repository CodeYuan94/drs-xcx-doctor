package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * patient_upload
 * @author 
 */
@Data
public class PatientUpload implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 患者id
     */
    private String patientId;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 资料类型
     */
    private Integer type;
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