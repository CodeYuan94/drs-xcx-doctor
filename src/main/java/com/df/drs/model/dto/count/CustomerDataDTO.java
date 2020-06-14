package com.df.drs.model.dto.count;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author yuan
 * @project drs
 * @description 客户数据DTO
 * @date 2020/6/8 17:26
 **/
@Data
public class CustomerDataDTO implements Serializable {

    private static final long serialVersionUID = -4607719217722592779L;

    /**
     * 新增客户量
     */
    @ApiModelProperty("新增客户量")
    private List<Map> newCustomer;

    /**
     * 预约客户量
     */
    @ApiModelProperty("预约客户量")
    private List<Map> appointmentCustomer;

    /**
     * 反诊客户
     */
    @ApiModelProperty("反诊客户量")
    private List<Map> returnVisitCustomer;
}
