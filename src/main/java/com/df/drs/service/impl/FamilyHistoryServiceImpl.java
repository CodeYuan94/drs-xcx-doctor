package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.ComFunc;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.FamilyHistoryDao;
import com.df.drs.model.dto.patient.FamilyHistoryDTO;
import com.df.drs.model.dto.patient.FamilyHistoryFemaleDTO;
import com.df.drs.model.dto.patient.FamilyHistoryMaleDTO;
import com.df.drs.model.entity.FamilyHistory;
import com.df.drs.service.FamilyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 家族史服务实现
 * @date 2020/6/4 13:40
 **/
@Service
public class FamilyHistoryServiceImpl implements FamilyHistoryService {

    @Autowired
    private FamilyHistoryDao familyHistoryDao;

    @Override
    public ResultBean<FamilyHistoryDTO> findByPatientId(String patientId) {
        List<FamilyHistory> familyHistories = familyHistoryDao.selectByPatientId(patientId);
        if (null ==familyHistories || familyHistories.isEmpty()) {
            return ResultBean.success("查询成功，数据为空！",null);
        } else {
            // 家族史
            FamilyHistoryDTO familyHistoryDTO = new FamilyHistoryDTO();
            // 男方家族史集合
            List<FamilyHistoryMaleDTO> familyHistoryMaleDTOS = new ArrayList<>();
            // 女方家族史集合
            List<FamilyHistoryFemaleDTO> familyHistoryFemaleDTOS = new ArrayList<>();
            for (FamilyHistory familyHistory : familyHistories) {
                int delflag = familyHistory.getDelflag();
                if (delflag == 0) {
                    // 0 男方
                    FamilyHistoryMaleDTO familyHistoryMaleDTO = CopyClassUtils.copyClassProperties(familyHistory,FamilyHistoryMaleDTO.class);
                    familyHistoryMaleDTOS.add(familyHistoryMaleDTO);
                    familyHistoryDTO.setFamilyHistoryMaleDTOS(familyHistoryMaleDTOS);
                } else if (delflag ==1) {
                    // 1 女方
                    FamilyHistoryFemaleDTO familyHistoryFemaleDTO = CopyClassUtils.copyClassProperties(familyHistory,FamilyHistoryFemaleDTO.class);
                    familyHistoryFemaleDTOS.add(familyHistoryFemaleDTO);
                    familyHistoryDTO.setFamilyHistoryFemaleDTOS(familyHistoryFemaleDTOS);
                } else {
                    return ResultBean.error(ErrorCode.QUERY_ERROR, "男女方标记错误！");
                }
            }
            return ResultBean.success("查询成功！", familyHistoryDTO);
        }
    }

    @Override
    public ResultBean saveFamilyHistory(FamilyHistoryDTO familyHistoryDTO, String patientId,String username) {
        // 男方家族史 0
        List<FamilyHistoryMaleDTO> familyHistoryMaleDTOS = familyHistoryDTO.getFamilyHistoryMaleDTOS();
        // 女方家族史 0
        List<FamilyHistoryFemaleDTO> familyHistoryFemaleDTOS = familyHistoryDTO.getFamilyHistoryFemaleDTOS();
        // 新的男方家族史集合
        List<FamilyHistoryMaleDTO> familyHistoryMaleDTOS1 = new ArrayList<>();
        // 新的女方家族史集合
        List<FamilyHistoryFemaleDTO> familyHistoryFemaleDTOS1 = new ArrayList<>();

        for (FamilyHistoryMaleDTO familyHistoryMaleDTO : familyHistoryMaleDTOS) {
            FamilyHistory familyHistory = CopyClassUtils.copyClassProperties(familyHistoryMaleDTO, FamilyHistory.class);
            String id = familyHistoryMaleDTO.getId();
            if (StringUtils.isNullOrEmpty(id)) {
                // id为空就添加
                familyHistory.setCreateUser(username);
                familyHistory.setGender(0);
                return addFamilyHistory(familyHistory);
            } else {
                // id不为空 放入新的集合
                familyHistoryMaleDTOS1.add(familyHistoryMaleDTO);
            }
        }

        for (FamilyHistoryFemaleDTO familyHistoryFemaleDTO : familyHistoryFemaleDTOS) {
            FamilyHistory familyHistory1 = CopyClassUtils.copyClassProperties(familyHistoryFemaleDTO, FamilyHistory.class);
            String id = familyHistoryFemaleDTO.getId();
            if (StringUtils.isNullOrEmpty(id)) {
                // id为空就添加
                familyHistory1.setCreateUser(username);
                familyHistory1.setGender(0);
                return addFamilyHistory(familyHistory1);
            } else {
                // id不为空 放入新的集合
                familyHistoryMaleDTOS1.add(familyHistoryFemaleDTO);
            }
        }

        // 查出数据库的家族史
        List<FamilyHistory> familyHistories = familyHistoryDao.selectByPatientId(patientId);
        // 男方家族史集合
        List<FamilyHistoryMaleDTO> familyHistoryMaleDTOS2 = new ArrayList<>();
        // 女方家族史集合
        List<FamilyHistoryFemaleDTO> familyHistoryFemaleDTOS2 = new ArrayList<>();
        for (FamilyHistory familyHistory : familyHistories) {
            int delflag = familyHistory.getDelflag();
            if (delflag == 0) {
                // 0 男方
                FamilyHistoryMaleDTO familyHistoryMaleDTO = CopyClassUtils.copyClassProperties(familyHistory,FamilyHistoryMaleDTO.class);
                familyHistoryMaleDTOS2.add(familyHistoryMaleDTO);
            } else if (delflag ==1) {
                // 1 女方
                FamilyHistoryFemaleDTO familyHistoryFemaleDTO = CopyClassUtils.copyClassProperties(familyHistory,FamilyHistoryFemaleDTO.class);
                familyHistoryFemaleDTOS2.add(familyHistoryFemaleDTO);
            } else {
                return ResultBean.error(ErrorCode.QUERY_ERROR, "男女方标记错误！");
            }
        }

        // 要删除的id集合
        List<String> ids = new ArrayList<>();
        boolean b = familyHistoryMaleDTOS2.removeAll(familyHistoryMaleDTOS1);
        if (b) {
            for (FamilyHistoryMaleDTO familyHistoryMaleDTO : familyHistoryMaleDTOS2) {
                ids.add(familyHistoryMaleDTO.getId());
            }
        }
        boolean b1 = familyHistoryFemaleDTOS2.removeAll(familyHistoryFemaleDTOS1);
        if (b1) {
            for (FamilyHistoryFemaleDTO familyHistoryFemaleDTO : familyHistoryFemaleDTOS2) {
                ids.add(familyHistoryFemaleDTO.getId());
            }
        }
        return removeFamilyHistory(ids);
    }

    /**
     * 插入家族史
     * @param familyHistory
     * @return
     */
    private ResultBean addFamilyHistory(FamilyHistory familyHistory) {
        familyHistory.setId(ComFunc.generateNo("FA"));
        familyHistory.setCreateTime(new Date());
        int i = familyHistoryDao.insertSelective(familyHistory);
        if (i > 0) {
            return ResultBean.success("插入成功！");
        }
        return ResultBean.error(ErrorCode.ADD_ERROR,"插入失败！");
    }

    /**
     * 删除家族史
     * @param
     * @return
     */
    private ResultBean removeFamilyHistory(List ids) {
        int i = familyHistoryDao.batchDelete(ids);
        if (i > 0) {
            return ResultBean.success("修改成功！");
        }
        return ResultBean.error(ErrorCode.CHANGE_ERROR,"修改失败！");
    }
}
