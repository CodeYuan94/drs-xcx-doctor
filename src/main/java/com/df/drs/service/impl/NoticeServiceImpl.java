package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.AppointmentDao;
import com.df.drs.model.dto.notice.AppointmentNoticeDTO;
import com.df.drs.model.dto.notice.RemindNoticeDTO;
import com.df.drs.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 通知服务实现
 * @date 2020/6/10 9:32
 **/
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public ResultBean<AppointmentNoticeDTO> findAppointmentNoticeDTO(String doctorId) {
        if (StringUtils.isNullOrEmpty(doctorId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL,"参数为空！");
        }
        List<AppointmentNoticeDTO> appointmentNoticeDTOS = appointmentDao.selectAppointmentByDoctorId(doctorId);
        Calendar calendar = Calendar.getInstance();
        for(AppointmentNoticeDTO appointmentNoticeDTO:appointmentNoticeDTOS) {
            Date appointmentTime = appointmentNoticeDTO.getAppointmentTime();

            calendar.setTime(appointmentTime);
            calendar.set(Calendar.HOUR_OF_DAY, 24);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            // 获取预约日的24点
            Date time = calendar.getTime();
            // 获取当前时间
            Date now = new Date();

            int compare = now.compareTo(time);
            if (compare>0) {
                // 过期
                appointmentNoticeDTO.setExpired(1);
            } else {
                // 未过期
                appointmentNoticeDTO.setExpired(0);
            }
        }
        return ResultBean.success("查询成功！",appointmentNoticeDTOS);
    }

    @Override
    public ResultBean<RemindNoticeDTO> findRemindNoticeDTO(String doctorId) {
        if (StringUtils.isNullOrEmpty(doctorId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL,"参数为空！");
        }
        List<RemindNoticeDTO> remindNoticeDTOS = appointmentDao.selectRemindByDoctorId(doctorId);
        Calendar calendar = Calendar.getInstance();
        for (RemindNoticeDTO remindNoticeDTO : remindNoticeDTOS) {
            Date endTime = remindNoticeDTO.getEndTime();
            calendar.setTime(endTime);
            calendar.set(Calendar.HOUR_OF_DAY, 24);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            // 获取提醒周期 结束日的24点
            Date time = calendar.getTime();
            // 获取当前时间
            Date now = new Date();

            int compare = now.compareTo(time);
            if (compare>0) {
                // 过期
                remindNoticeDTO.setExpired(1);
            } else {
                // 未过期
                remindNoticeDTO.setExpired(0);
            }
        }
        return ResultBean.success("查询成功！",remindNoticeDTOS);
    }
}
