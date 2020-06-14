package com.df.drs.model.dto.count;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 本周客户数据量
 * @date 2020/6/9 16:41
 **/
@Data
public class WeekCustomerDataDTO implements Serializable {

    private static final long serialVersionUID = -8907451302720013477L;

    /**
     * 日期
     */
    private String date;

    /**
     * 数量
     */
    private Integer amount;
}
