package com.df.drs.model.dto.patient;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 男方家族史dto
 * @date 2020/6/5 16:55
 **/
@Data
public class FamilyHistoryMaleDTO implements Serializable {

    private static final long serialVersionUID = -4145287164346772178L;

    /**
     * id
     */
    private String id;

    /**
     * 患者id
     */
    private String patientId;

    /**
     * 家族成员
     */
    private String familyMember;

    /**
     * 染色体平衡移位（标记）
     */
    private Integer chromosomalBalancedTranslocation;

    /**
     * 单基因病（标记）
     */
    private Integer monogenicDisease;

    /**
     * 染色体异常（标记）
     */
    private Integer chromosomeAbnormalities;

    /**
     * 不孕病史（标记）
     */
    private Integer infertilityHistory;

    /**
     * 详情
     */
    private String detail;
}
