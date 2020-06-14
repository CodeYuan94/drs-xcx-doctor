package com.df.drs.model.dto.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 患者上传资料dto
 * @date 2020/6/3 11:03
 **/
@Data
public class PatientUploadDTO implements Serializable {

    private static final long serialVersionUID = 4247348693728230213L;

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
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String imageUrl;

    /**
     * 资料类型
     */
    @ApiModelProperty("资料类型")
    private Integer type;
}
