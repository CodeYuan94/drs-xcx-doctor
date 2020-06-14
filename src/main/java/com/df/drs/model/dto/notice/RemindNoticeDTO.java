package com.df.drs.model.dto.notice;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * @author yuan
 * @project drs
 * @description 提醒消息DTO
 * @date 2020/6/10 10:35
 **/
@Data
public class RemindNoticeDTO implements Serializable {

    private static final long serialVersionUID = 7663235598629153373L;

    /**
     * 提醒类型
     */
    @ApiModelProperty("提醒类型")
    private String type;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remarks;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endTime;

    /**
     * 提醒时间
     */
    @ApiModelProperty("提醒时间")
    private Time remindTime;


    /**
     * 过期标记
     */
    @ApiModelProperty("过期标记(0:未过期  1：已过期)")
    private Integer expired;
}
