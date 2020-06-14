package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.ComFunc;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.MenstruationHistoryDao;
import com.df.drs.model.dto.patient.MenstruationHistoryDTO;
import com.df.drs.model.entity.MenstruationHistory;
import com.df.drs.service.MenstruationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 月经史服务实现
 * @date 2020/6/4 10:30
 **/
@Service
public class MenstruationHistoryServiceImpl implements MenstruationHistoryService {

    @Autowired
    private MenstruationHistoryDao menstruationHistoryDao;

    @Override
    public ResultBean<MenstruationHistoryDTO> findByPatientId(String patientId) {
        List<MenstruationHistory> menstruationHistories = menstruationHistoryDao.selectByPatientId(patientId);
        if (null == menstruationHistories || menstruationHistories.isEmpty()) {
            return ResultBean.success("查询成功，数据为空！",null);
        } else {
            List<MenstruationHistoryDTO> menstruationHistoryDTOS = CopyClassUtils.copyListProperties(menstruationHistories,MenstruationHistoryDTO.class);
            return ResultBean.success("查询成功！",menstruationHistoryDTOS);
        }
    }

    @Override
    public ResultBean saveMenstruationHistory(MenstruationHistoryDTO menstruationHistoryDTO, String username) {
        MenstruationHistory menstruationHistory = CopyClassUtils.copyClassProperties(menstruationHistoryDTO,MenstruationHistory.class);
        String id = menstruationHistoryDTO.getId();

        if (StringUtils.isNullOrEmpty(id)) {
            // id为空，插入
            menstruationHistory.setCreateUser(username);
            return addMenstruationHistory(menstruationHistory);
        } else {
            // id不为空
            MenstruationHistory menstruationHistory1 = menstruationHistoryDao.selectByPrimaryKey(id);
            if (null != menstruationHistory1) {
                // 通过id能查到，更新
                menstruationHistory.setUpdateUser(username);
                return modifyMenstruationHistory(menstruationHistory);
            } else {
                return ResultBean.error(ErrorCode.CHANGE_ERROR,"id错误");
            }
        }
    }


    /**
     * 插入月经史
     * @param menstruationHistory
     * @return
     */
    private ResultBean addMenstruationHistory(MenstruationHistory menstruationHistory) {
        menstruationHistory.setId(ComFunc.generateNo("MEN"));
        menstruationHistory.setCreateTime(new Date());
        int i = menstruationHistoryDao.insertSelective(menstruationHistory);
        if (i > 0) {
            return ResultBean.success("插入成功！");
        }
        return ResultBean.error(ErrorCode.ADD_ERROR,"插入失败！");
    }

    /**
     * 修改月经史
     * @param menstruationHistory
     * @return
     */
    private ResultBean modifyMenstruationHistory(MenstruationHistory menstruationHistory) {
        menstruationHistory.setUpdateTime(new Date());
        int i = menstruationHistoryDao.updateByPrimaryKeySelective(menstruationHistory);
        if (i > 0) {
            return ResultBean.success("修改成功！");
        }
        return ResultBean.error(ErrorCode.CHANGE_ERROR,"修改失败！");
    }
}
