package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.patient.PastHistoryDTO;

/**
 * @author yuan
 * @project drs
 * @description 既往史服务接口
 * @date 2020/6/4 13:12
 **/
public interface PastHistoryService {

    /**
     * 通过patientId查找既往史
     * @param patientId
     * @return
     */
    ResultBean<PastHistoryDTO> findByPatientId(String patientId);

    /**
     * 保存既往史
     * @param pastHistoryDTO
     * @param username
     * @return
     */
    ResultBean savePastHistory(PastHistoryDTO pastHistoryDTO, String username);
}
