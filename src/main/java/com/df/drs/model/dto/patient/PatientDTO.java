package com.df.drs.model.dto.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 患者个人资料dto
 * @date 2020/6/3 9:44
 **/
@Data
public class PatientDTO implements Serializable {

    private static final long serialVersionUID = 630018208010584628L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private String id;

    /**
     * 女方患者姓名
     */
    @ApiModelProperty("女方患者姓名")
    private String femaleName;

    /**
     * 女方年龄
     */
    @ApiModelProperty("女方年龄")
    private Integer femaleAge;

    /**
     * 女方身高
     */
    @ApiModelProperty("女方身高")
    private Integer femaleHeight;

    /**
     * 女方体重
     */
    @ApiModelProperty("女方体重")
    private Integer femaleWeight;

    /**
     * 男方患者姓名
     */
    @ApiModelProperty("男方患者姓名")
    private String maleName;

    /**
     * 男方年龄
     */
    @ApiModelProperty("男方年龄")
    private Integer maleAge;

    /**
     * 男方身高
     */
    @ApiModelProperty("男方身高")
    private Integer maleHeight;

    /**
     * 男方体重
     */
    @ApiModelProperty("男方体重")
    private Integer maleWeight;
}
