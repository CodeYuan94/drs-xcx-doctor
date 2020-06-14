package com.df.drs.model.dto.notice;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuan
 * @project drs
 * @description 预约消息DTO
 * @date 2020/6/10 10:13
 **/
@Data
public class AppointmentNoticeDTO implements Serializable {

    private static final long serialVersionUID = 5057849591893178700L;

    /**
     * 预约类型
     */
    @ApiModelProperty("预约类型")
    private String type;

    /**
     * 患者姓名
     */
    @ApiModelProperty("患者姓名")
    private String patientName;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remarks;

    /**
     * 预约时间
     */
    @ApiModelProperty("预约时间")
    private Date appointmentTime;

    /**
     * 是否全天标记
     */
    @ApiModelProperty("是否全天标记(0:否  1：是)")
    private Integer fullDay;

    /**
     * 过期标记
     */
    @ApiModelProperty("过期标记(0:未过期  1：已过期)")
    private Integer expired;
}
