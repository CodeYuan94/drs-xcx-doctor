package com.df.drs.model.dto.patient;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 男方既往史dto
 * @date 2020/6/5 15:14
 **/
@Data
public class PastHistoryMaleDTO implements Serializable {

    private static final long serialVersionUID = -7592994981451379379L;

    /**
     * id
     */
    private String id;

    /**
     * 患者id
     */
    @NotNull
    private String patientId;

    /**
     * 肝炎
     */
    private Integer hepatitis;

    /**
     * 结核
     */
    private Integer tuberculosis;

    /**
     * 肾脏疾病
     */
    private Integer kidneyDisease;

    /**
     * 心血管疾病
     */
    private Integer cardiovascularDisease;

    /**
     * 尿路系感染
     */
    private Integer urinaryTractInfection;

    /**
     * 性传播疾病史
     */
    private Integer sexuallyTransmittedDiseaseHistory;

    /**
     * 阑尾炎
     */
    private Integer appendicitis;

    /**
     * 其他疾病
     */
    private String remarks;
}
