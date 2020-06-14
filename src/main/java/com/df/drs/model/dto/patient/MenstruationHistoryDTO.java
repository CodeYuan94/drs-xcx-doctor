package com.df.drs.model.dto.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yuan
 * @project drs
 * @description 月经史dto
 * @date 2020/6/3 9:58
 **/
@Data
public class MenstruationHistoryDTO implements Serializable {

    private static final long serialVersionUID = -3294881633206207787L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private String id;

    /**
     * 患者id
     */
    @NotNull
    @ApiModelProperty("患者id")
    private String patientId;

    /**
     * 初潮
     */
    @ApiModelProperty("初潮")
    private Integer menarche;

    /**
     * 经量
     */
    @ApiModelProperty("经量")
    private Integer mensAmount;

    /**
     * 痛经程度
     */
    @ApiModelProperty("痛经程度")
    private Integer dysmenorrhea;

    /**
     * 性交痛
     */
    @ApiModelProperty("性交痛")
    private Integer coitalPain;

    /**
     * 末次月经首日
     */
    @ApiModelProperty("末次月经首日")
    private Date lastMensFirstDay;

    /**
     * 月经周期min
     */
    @ApiModelProperty("月经周期min")
    private Integer mensCycleMin;

    /**
     * 月经周期max
     */
    @ApiModelProperty("月经周期max")
    private Integer mensCycleMax;

    /**
     * 经期min
     */
    @ApiModelProperty("经期min")
    private Integer mensPeriodMin;

    /**
     * 经期max
     */
    @ApiModelProperty("经期max")
    private Integer mensPeriodMax;


}
