package com.df.drs.service.impl;

import com.df.drs.model.dto.count.CustomerDataDTO;
import com.df.drs.model.dto.count.ManageDataDTO;
import com.df.drs.service.CountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 统计服务实现
 * @date 2020/6/8 18:26
 **/
@Service
public class CountServiceImpl implements CountService {


    @Override
    public List<CustomerDataDTO> findWeekCustomerData() {
        // TODO
        return null;
    }

    @Override
    public List<CustomerDataDTO> findMonthCustomerData() {
        return null;
    }

    @Override
    public List<CustomerDataDTO> findYearCustomerData() {
        return null;
    }

    @Override
    public List<ManageDataDTO> findWeekManageData() {
        return null;
    }

    @Override
    public List<ManageDataDTO> findMonthManageData() {
        return null;
    }

    @Override
    public List<ManageDataDTO> findYearManageData() {
        return null;
    }
}
