package com.df.drs.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * marriage_history
 * @author 
 */
@Data
public class MarriageHistory implements Serializable {
    /**
     * id
     */
    private String id;

    /**
     * 患者资料
     */
    private String patientId;

    /**
     * 女方婚姻史
     */
    private Integer femaleMarriageHistory;

    /**
     * 未孕(年)
     */
    private Integer unpregnantYear;

    /**
     * 婚龄
     */
    private Date marriageAge;

    /**
     * 末次妊娠时间
     */
    private Date lastGestation;

    /**
     * 足月产
     */
    private Integer termBirth;

    /**
     * 早产
     */
    private Integer prematureBirth;

    /**
     * 胚停
     */
    private Integer embryoDiscontinuation;

    /**
     * 自然流产
     */
    private Integer spontaneousAbortion;

    /**
     * 人工流产
     */
    private Integer artificialAbortion;

    /**
     * 生化妊娠
     */
    private Integer biochemicalPregnancy;

    /**
     * 引产
     */
    private Integer inducedLabour;

    /**
     * 宫外孕
     */
    private Integer vectopicPregnancy;

    /**
     * 现存
     */
    private Integer existingChildren;

    /**
     * 女方其他情况
     */
    private String femaleRemarks;

    /**
     * 男方婚姻史
     */
    private Integer maleMarriageHistory;

    /**
     * 男方生育史
     */
    private Integer maleFertilityHistory;

    /**
     * 男方其他情况
     */
    private String maleRemarks;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 删除标记
     */
    private Integer delflag;

    /**
     * 未孕（月）
     */
    private Integer unpregnantMonth;

    /**
     * 前任足月产
     */
    private Integer exTermBirth;

    /**
     * 前任早产
     */
    private Integer exPrematureBirth;

    /**
     * 前任胚停
     */
    private Integer exEmbryoDiscontinuation;

    /**
     * 前任自然流产
     */
    private Integer exSpontaneousAbortion;

    /**
     * 前任人工流产
     */
    private Integer exArtificialAbortion;

    /**
     * 前任生化妊娠
     */
    private Integer exBiochemicalPregnancy;

    /**
     * 前任引产
     */
    private Integer exInducedLabour;

    /**
     * 前任宫外孕
     */
    private Integer exVectopicPregnancy;

    /**
     * 前任现存
     */
    private Integer exExistingChildren;

    private static final long serialVersionUID = 1L;
}