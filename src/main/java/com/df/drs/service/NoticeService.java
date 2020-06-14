package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.notice.AppointmentNoticeDTO;
import com.df.drs.model.dto.notice.RemindNoticeDTO;

/**
 * @author yuan
 * @project drs
 * @description 消息服务接口
 * @date 2020/6/10 10:41
 **/
public interface NoticeService {

    /**
     * 查找医生的预约消息
     * @param doctorId
     * @return
     */
    ResultBean<AppointmentNoticeDTO> findAppointmentNoticeDTO(String doctorId);

    /**
     * 查找医生的提醒消息
     * @param doctorId
     * @return
     */
    ResultBean<RemindNoticeDTO> findRemindNoticeDTO(String doctorId);
}
