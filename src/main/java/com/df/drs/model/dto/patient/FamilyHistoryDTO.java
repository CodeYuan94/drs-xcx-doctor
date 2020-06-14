package com.df.drs.model.dto.patient;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @author yuan
 * @project drs
 * @description 家族史dto
 * @date 2020/6/3 10:35
 **/
@Data
public class FamilyHistoryDTO implements Serializable {

    private static final long serialVersionUID = -8585756037933428358L;

    /**
     * 男方家族史dto
     */
    private List<FamilyHistoryMaleDTO> familyHistoryMaleDTOS;

    /**
     * 女方家族史dto
     */
    private List<FamilyHistoryFemaleDTO> familyHistoryFemaleDTOS;
}
