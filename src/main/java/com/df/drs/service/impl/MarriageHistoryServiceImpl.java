package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.ComFunc;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.MarriageHistoryDao;
import com.df.drs.model.dto.patient.MarriageHistoryDTO;
import com.df.drs.model.entity.MarriageHistory;
import com.df.drs.service.MarriageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author yuan
 * @project drs
 * @description 婚育史服务实现
 * @date 2020/6/4 11:48
 **/
@Service
public class MarriageHistoryServiceImpl implements MarriageHistoryService {

    @Autowired
    private MarriageHistoryDao marriageHistoryDao;

    @Override
    public ResultBean<MarriageHistoryDTO> findByPatientId(String patientId) {
        List<MarriageHistory> marriageHistories = marriageHistoryDao.selectByPatientId(patientId);
        if (null == marriageHistories || marriageHistories.isEmpty()) {
            return ResultBean.success("查询成功，数据为空！",null);
        } else {
            List<MarriageHistoryDTO> marriageHistoryDTOS = CopyClassUtils.copyListProperties(marriageHistories,MarriageHistoryDTO.class);
            return ResultBean.success("查询成功！",marriageHistoryDTOS);
        }
    }

    @Override
    public ResultBean saveMarriageHistory(MarriageHistoryDTO marriageHistoryDTO, String username) {
        MarriageHistory marriageHistory = CopyClassUtils.copyClassProperties(marriageHistoryDTO,MarriageHistory.class);
        String id = marriageHistoryDTO.getId();

        if (StringUtils.isNullOrEmpty(id)) {
            // id为空，插入
            marriageHistory.setCreateUser(username);
            return addMarriageHistory(marriageHistory);
        } else {
            // id不为空
            MarriageHistory marriageHistory1 = marriageHistoryDao.selectByPrimaryKey(id);
            if (null != marriageHistory1) {
                // 通过id能查到，更新
                marriageHistory.setUpdateUser(username);
                return modifyMarriageHistory(marriageHistory);
            } else {
                return ResultBean.error(ErrorCode.CHANGE_ERROR,"id错误");
            }
        }
    }

    /**
     * 插入婚育史
     * @param marriageHistory
     * @return
     */
    private ResultBean addMarriageHistory(MarriageHistory marriageHistory) {
        marriageHistory.setId(ComFunc.generateNo("MA"));
        marriageHistory.setCreateTime(new Date());
        int i = marriageHistoryDao.insertSelective(marriageHistory);
        if (i > 0) {
            return ResultBean.success("插入成功！");
        }
        return ResultBean.error(ErrorCode.ADD_ERROR,"插入失败！");
    }

    private ResultBean modifyMarriageHistory(MarriageHistory marriageHistory) {
        marriageHistory.setUpdateTime(new Date());
        int i = marriageHistoryDao.updateByPrimaryKeySelective(marriageHistory);
        if (i > 0) {
            return ResultBean.success("修改成功！");
        }
        return ResultBean.error(ErrorCode.CHANGE_ERROR,"修改失败！");
    }
}
