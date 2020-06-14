package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.patient.MenstruationHistoryDTO;

/**
 * @author yuan
 * @project drs
 * @description 月经史服务接口
 * @date 2020/6/4 10:22
 **/
public interface MenstruationHistoryService {

    /**
     * 通过patientId查找月经史
     * @param patientId
     * @return
     */
    ResultBean<MenstruationHistoryDTO> findByPatientId(String patientId);

    /**
     * 保存月经史
     * @param menstruationHistoryDTO
     * @param username
     * @return
     */
    ResultBean saveMenstruationHistory(MenstruationHistoryDTO menstruationHistoryDTO, String username);
}
