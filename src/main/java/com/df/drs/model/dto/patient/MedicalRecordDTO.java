package com.df.drs.model.dto.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuan
 * @project drs
 * @description 就诊履历DTO
 * @date 2020/6/10 18:22
 **/
@Data
public class MedicalRecordDTO implements Serializable {

    private static final long serialVersionUID = -6451138278532470940L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private String id;

    /**
     * 医生姓名
     */
    @ApiModelProperty("医生姓名")
    private String doctorName;

    /**
     * 助理姓名
     */
    @ApiModelProperty("助理姓名")
    private String assistantName;

    /**
     * 就诊时间
     */
    @ApiModelProperty("就诊时间")
    private Date consultationTime;

    /**
     * 就诊阶段(0:出诊 1:复诊)
     */
    @ApiModelProperty("就诊阶段(0:出诊 1:复诊)")
    private Integer consultationStage;

    /**
     * 就诊内容
     */
    @ApiModelProperty("就诊内容")
    private String consultationContent;

    /**
     * 处理意见
     */
    @ApiModelProperty("处理意见")
    private String handleOpinion;
}
