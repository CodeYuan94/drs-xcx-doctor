package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.patient.FamilyHistoryDTO;


/**
 * @author yuan
 * @project drs
 * @description 家族史服务接口
 * @date 2020/6/4 13:37
 **/
public interface FamilyHistoryService {

    /**
     * 通过patientid查找家族史
     * @param patientId
     * @return
     */
    ResultBean<FamilyHistoryDTO> findByPatientId(String patientId);

    /**
     * 保存家族史
     * @param familyHistoryDTO
     * @param username
     * @param username
     * @return
     */
    ResultBean saveFamilyHistory(FamilyHistoryDTO familyHistoryDTO, String patientId, String username);
}
