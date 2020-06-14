package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.ComFunc;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.PastHistoryDao;
import com.df.drs.model.dto.patient.PastHistoryDTO;
import com.df.drs.model.dto.patient.PastHistoryFemaleDTO;
import com.df.drs.model.dto.patient.PastHistoryMaleDTO;
import com.df.drs.model.entity.PastHistory;
import com.df.drs.service.PastHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 既往史服务
 * @date 2020/6/4 13:15
 **/
@Repository
public class PastHistoryServiceImpl implements PastHistoryService {

    @Autowired
    private PastHistoryDao pastHistoryDao;

    @Override
    public ResultBean<PastHistoryDTO> findByPatientId(String patientId) {
        List<PastHistory> pastHistories = pastHistoryDao.selectByPatientId(patientId);
        if (null == pastHistories || pastHistories.isEmpty()) {
            return ResultBean.success("查询成功，数据为空！",null);
        } else {
            // 既往史
            PastHistoryDTO pastHistoryDTO = new PastHistoryDTO();
            // 男方既往史集合
            List<PastHistoryMaleDTO> pastHistoryMaleDTOS = new ArrayList<>();
            // 女方既往史集合
            List<PastHistoryFemaleDTO> pastHistoryFemaleDTOS = new ArrayList<>();

            for (PastHistory pastHistory : pastHistories) {
                int delflag = pastHistory.getDelflag();
                if (delflag == 0) {
                    // 0 男方既往史
                    PastHistoryMaleDTO pastHistoryMaleDTO = CopyClassUtils.copyClassProperties(pastHistory, PastHistoryMaleDTO.class);
                    pastHistoryMaleDTOS.add(pastHistoryMaleDTO);
                    pastHistoryDTO.setPastHistoryMaleDTOS(pastHistoryMaleDTOS);
                } else if (delflag == 1) {
                    // 1 女方既往史
                    PastHistoryFemaleDTO pastHistoryFemaleDTO = CopyClassUtils.copyClassProperties(pastHistory, PastHistoryFemaleDTO.class);
                    pastHistoryFemaleDTOS.add(pastHistoryFemaleDTO);
                    pastHistoryDTO.setPastHistoryFemaleDTOS(pastHistoryFemaleDTOS);
                } else {
                    return ResultBean.error(ErrorCode.QUERY_ERROR, "男女方标记错误！");
                }
            }
            return ResultBean.success("查询成功！", pastHistoryDTO);
        }
    }

    @Override
    public ResultBean savePastHistory(PastHistoryDTO pastHistoryDTO, String username) {
        // 男方既往史 0
        List<PastHistoryMaleDTO> pastHistoryMaleDTOS = pastHistoryDTO.getPastHistoryMaleDTOS();
        for (PastHistoryMaleDTO pastHistoryMaleDTO : pastHistoryMaleDTOS) {
            PastHistory pastHistory = CopyClassUtils.copyClassProperties(pastHistoryMaleDTO,PastHistory.class);
            String id = pastHistoryMaleDTO.getId();
            if (StringUtils.isNullOrEmpty(id)) {
                // id为空，插入
                pastHistory.setCreateUser(username);
                pastHistory.setGender(0);
                return addPastHistory(pastHistory);
            } else {
                // id不为空
                PastHistory pastHistory1 = pastHistoryDao.selectByPrimaryKey(id);
                if (null != pastHistory1) {
                    // 通过id能查到就更新
                    pastHistory.setUpdateUser(username);
                    return modifyPastHistory(pastHistory);
                } else {
                    return ResultBean.error(ErrorCode.CHANGE_ERROR, "id错误");
                }
            }
        }
        // 女方既往史
        List<PastHistoryFemaleDTO> pastHistoryFemaleDTOS = pastHistoryDTO.getPastHistoryFemaleDTOS();
        for (PastHistoryFemaleDTO pastHistoryFemaleDTO : pastHistoryFemaleDTOS) {
            PastHistory pastHistory = CopyClassUtils.copyClassProperties(pastHistoryFemaleDTO,PastHistory.class);
            String id = pastHistoryFemaleDTO.getId();
            if (StringUtils.isNullOrEmpty(id)) {
                // id为空，插入
                pastHistory.setCreateUser(username);
                pastHistory.setGender(1);
                return addPastHistory(pastHistory);
            } else {
                // id不为空
                PastHistory pastHistory1 = pastHistoryDao.selectByPrimaryKey(id);
                if (null != pastHistory1) {
                    // 通过id能查到就更新
                    pastHistory.setUpdateUser(username);
                    return modifyPastHistory(pastHistory);
                } else {
                    return ResultBean.error(ErrorCode.CHANGE_ERROR, "id错误");
                }
            }
        }
        return null;
    }

    /**
     * 插入既往史
     *
     * @param pastHistory
     * @return
     */
    private ResultBean addPastHistory(PastHistory pastHistory) {
        pastHistory.setId(ComFunc.generateNo("PAS"));
        pastHistory.setCreateTime(new Date());
        int i = pastHistoryDao.insertSelective(pastHistory);
        if (i > 0) {
            return ResultBean.success("插入成功！");
        }
        return ResultBean.error(ErrorCode.ADD_ERROR, "插入失败！");
    }

    /**
     * 修改既往史
     *
     * @param pastHistory
     * @return
     */
    private ResultBean modifyPastHistory(PastHistory pastHistory) {
        pastHistory.setUpdateTime(new Date());
        int i = pastHistoryDao.updateByPrimaryKeySelective(pastHistory);
        if (i > 0) {
            return ResultBean.success("修改成功！");
        }
        return ResultBean.error(ErrorCode.CHANGE_ERROR, "修改失败！");
    }
}
