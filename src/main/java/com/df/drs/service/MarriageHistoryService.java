package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.patient.MarriageHistoryDTO;


/**
 * @author yuan
 * @project drs
 * @description 婚育史服务接口
 * @date 2020/6/4 11:42
 **/
public interface MarriageHistoryService {

    /**
     * 通过patientId查找婚育史
     * @param patientId
     * @return
     */
    ResultBean<MarriageHistoryDTO> findByPatientId (String patientId);

    /**
     * 保存婚育史
     * @param marriageHistoryDTO
     * @param username
     * @return
     */
    ResultBean saveMarriageHistory(MarriageHistoryDTO marriageHistoryDTO, String username);
}
