package com.df.drs.model.dto.schedule;

import com.alibaba.fastjson.annotation.JSONField;
import com.df.drs.base.annotation.Recommend;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * 日程DTO
 */
@Data
public class ScheduleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private String id;

    /**
     * 医生id
     */
    @ApiModelProperty("医生id")
    private String doctorId;

    /**
     * 患者id
     */
    @ApiModelProperty("患者id")
    private String patientId;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    @Recommend(col = "startTime",recommend = "开始时间")
    @JSONField(name = "startTime", format = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    @Recommend(col = "endTime",recommend = "结束时间")
    @JSONField(name = "endTime", format = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 提醒时间
     */
    @ApiModelProperty("提醒时间")
    @Recommend(col = "remindTime", format = "HH:mm:ss", recommend = "提醒时间")
    @JSONField(name = "remindTime", format = "HH:mm:ss")
    private Time remindTime;

    /**
     * 预约时间
     */
    @ApiModelProperty("预约时间")
    @Recommend(col = "appointmentTime",format = "yyyy-MM-dd HH:mm:ss", recommend = "预约时间")
    @JSONField(name = "appointmentTime", format = "yyyy-MM-dd HH:mm:ss")
    private Date appointmentTime;

    /**
     * 是否全天
     */
    @ApiModelProperty("是否全天")
    private Integer fullDay;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remarks;
    /**
     * 完成标记
     */
    @ApiModelProperty("完成标记")
    private Integer completed;

}
