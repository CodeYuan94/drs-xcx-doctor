package com.df.drs.model.dto.patient;

import lombok.Data;

/**
 * @author yuan
 * @project drs
 * @description 女方既往史dto
 * @date 2020/6/5 15:16
 **/
@Data
public class PastHistoryFemaleDTO extends PastHistoryMaleDTO {

    /**
     * 盆腔炎
     */
    private Integer pelvicInfection;
}
