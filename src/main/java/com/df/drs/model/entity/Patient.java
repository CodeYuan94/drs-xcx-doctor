package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * patient
 * @author 
 */
@Data
public class Patient implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 女方患者姓名
     */
    private String femaleName;

    /**
     * 女方年龄
     */
    private Integer femaleAge;

    /**
     * 女方身高
     */
    private Integer femaleHeight;

    /**
     * 女方体重
     */
    private Integer femaleWeight;

    /**
     * 男方患者姓名
     */
    private String maleName;

    /**
     * 男方年龄
     */
    private Integer maleAge;

    /**
     * 男方身高
     */
    private Integer maleHeight;

    /**
     * 男方体重
     */
    private Integer maleWeight;

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