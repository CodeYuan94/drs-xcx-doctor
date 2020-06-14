package com.df.drs.model.dto.patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yuan
 * @project drs
 * @description 婚育史dto
 * @date 2020/6/3 10:03
 **/
@Data
public class MarriageHistoryDTO implements Serializable {

    private static final long serialVersionUID = 4232630439713138759L;

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
     * 女方婚姻史
     */
    @ApiModelProperty("女方婚姻史")
    private Integer femaleMarriageHistory;

    /**
     * 未孕(年)
     */
    @ApiModelProperty("未孕(年)")
    private Integer unpregnantYear;

    /**
     * 未孕（月）
     */
    @ApiModelProperty("未孕（月）")
    private Integer unpregnantMonth;

    /**
     * 婚龄
     */
    @ApiModelProperty("婚龄")
    private Date marriageAge;

    /**
     * 末次妊娠时间
     */
    @ApiModelProperty("末次妊娠时间")
    private Date lastGestation;

    /**
     * 足月产
     */
    @ApiModelProperty("足月产")
    private Integer termBirth;

    /**
     * 前任足月产
     */
    @ApiModelProperty("前任足月产")
    private Integer exTermBirth;

    /**
     * 早产
     */
    @ApiModelProperty("早产")
    private Integer prematureBirth;

    /**
     * 前任早产
     */
    @ApiModelProperty("前任早产")
    private Integer exPrematureBirth;

    /**
     * 胚停
     */
    @ApiModelProperty("胚停")
    private Integer embryoDiscontinuation;

    /**
     * 前任胚停
     */
    @ApiModelProperty("前任胚停")
    private Integer exEmbryoDiscontinuation;

    /**
     * 自然流产
     */
    @ApiModelProperty("自然流产")
    private Integer spontaneousAbortion;

    /**
     * 前任自然流产
     */
    @ApiModelProperty("前任自然流产")
    private Integer exSpontaneousAbortion;

    /**
     * 人工流产
     */
    @ApiModelProperty("人工流产")
    private Integer artificialAbortion;

    /**
     * 前任人工流产
     */
    @ApiModelProperty("前任人工流产")
    private Integer exArtificialAbortion;

    /**
     * 生化妊娠
     */
    @ApiModelProperty("生化妊娠")
    private Integer biochemicalPregnancy;

    /**
     * 前任生化妊娠
     */
    @ApiModelProperty("前任生化妊娠")
    private Integer exBiochemicalPregnancy;

    /**
     * 引产
     */
    @ApiModelProperty("引产")
    private Integer inducedLabour;

    /**
     * 前任引产
     */
    @ApiModelProperty("前任引产")
    private Integer exInducedLabour;

    /**
     * 宫外孕
     */
    @ApiModelProperty("宫外孕")
    private Integer vectopicPregnancy;

    /**
     * 前任宫外孕
     */
    @ApiModelProperty("前任宫外孕")
    private Integer exVectopicPregnancy;

    /**
     * 现存
     */
    @ApiModelProperty("现存")
    private Integer existingChildren;

    /**
     * 前任现存
     */
    @ApiModelProperty("前任现存")
    private Integer exExistingChildren;

    /**
     * 女方其他情况
     */
    @ApiModelProperty("女方其他情况")
    private String femaleRemarks;

    /**
     * 男方婚姻史
     */
    @ApiModelProperty("男方婚姻史")
    private Integer maleMarriageHistory;

    /**
     * 男方生育史
     */
    @ApiModelProperty("男方生育史")
    private Integer maleFertilityHistory;

    /**
     * 男方其他情况
     */
    @ApiModelProperty("男方其他情况")
    private String maleRemarks;




}
