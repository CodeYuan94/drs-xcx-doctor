package com.df.drs.model.dto.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 患者标签dto
 * @date 2020/6/5 14:41
 **/
@Data
public class PatientLabelDTO implements Serializable {

    private static final long serialVersionUID = 3416274017093884866L;
    /**
     * id
     */
    @ApiModelProperty("id")
    private String id;

    /**
     * 患者id
     */
    @ApiModelProperty("id")
    private String patientId;

    /**
     * 标签id
     */
    @ApiModelProperty("id")
    private String labelId;
}
