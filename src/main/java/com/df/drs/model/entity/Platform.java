package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * platform
 * @author 
 */
@Data
public class Platform implements Serializable {
    /**
     * id
     */
    private String id;

    private String doctorId;

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
     * 平台名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 二维码
     */
    private String qrCodeUrl;

    private static final long serialVersionUID = 1L;
}