package com.df.drs.service;


import com.df.drs.model.dto.count.CustomerDataDTO;
import com.df.drs.model.dto.count.ManageDataDTO;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 统计服务接口
 * @date 2020/6/8 17:56
 **/
public interface CountService {

    /**
     * 获取本周客户数据
     * @return
     */
    List<CustomerDataDTO> findWeekCustomerData();

    /**
     * 获取本月客户数据
     * @return
     */
    List<CustomerDataDTO> findMonthCustomerData();

    /**
     * 获取今年客户数据
     * @return
     */
    List<CustomerDataDTO> findYearCustomerData();

    /**
     * 获取本周经营数据
     * @return
     */
    List<ManageDataDTO> findWeekManageData();

    /**
     * 获取本月经营数据
     * @return
     */
    List<ManageDataDTO> findMonthManageData();

    /**
     * 获取今年经营数据
     */
    List<ManageDataDTO> findYearManageData();
}
