package com.df.drs.model.dto.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 患者标签配置DTO
 * @date 2020/6/5 9:57
 **/
@Data
public class PatientLabelConfigDTO implements Serializable {

    private static final long serialVersionUID = -6493065779045430767L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private String id;

    /**
     * 标签名
     */
    @ApiModelProperty("标签名")
    private String labelName;
}
