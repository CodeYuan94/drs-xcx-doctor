package com.df.drs.model.dto.doctor;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description doctor资料dto
 * @date 2020/6/3 13:20
 **/
@Data
public class DoctorDTO implements Serializable {

    private static final long serialVersionUID = -2600725453222325002L;
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
     * 其他平台
     */
    private String platformId;

    /**
     * 头像
     */
    private String photoUrl;

    /**
     * 职称
     */
    private String positionalTitle;

    /**
     * 擅长疾病
     */
    private String diseaseId;

    /**
     * 手机号
     */
    private String phone;
}
