package com.df.drs.model.dto.patient;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 既往史dto
 * @date 2020/6/3 10:29
 **/
@Data
public class PastHistoryDTO implements Serializable {

    private static final long serialVersionUID = 1406315904790755433L;

    /**
     * 女方既往史集合
     */
    private List<PastHistoryFemaleDTO> pastHistoryFemaleDTOS;

    /**
     * 男方既往史集合
     */
    private List<PastHistoryMaleDTO> pastHistoryMaleDTOS;

}
