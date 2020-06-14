package com.df.drs.model.dto.count;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 经营数据DTO
 * @date 2020/6/8 17:49
 **/
@Data
public class ManageDataDTO implements Serializable {

    private static final long serialVersionUID = -5785476695145430553L;

    /**
     * 接诊量
     */
    @ApiModelProperty("接诊量")
    private List<Integer> receivePatient;

    /**
     * 推广信息访问量
     */
    @ApiModelProperty("推广信息访问量")
    private List<Integer> promotionVisit;
}
