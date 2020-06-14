package com.df.drs.dao;


import com.df.drs.model.dto.count.WeekCustomerDataDTO;
import com.df.drs.model.dto.notice.AppointmentNoticeDTO;
import com.df.drs.model.dto.notice.RemindNoticeDTO;
import com.df.drs.model.dto.schedule.ScheduleDTO;
import com.df.drs.model.entity.Appointment;

import java.util.List;

public interface AppointmentDao {
    int deleteByPrimaryKey(String id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(String id);

    /**
     * 查新医生的预约消息
     * @param doctorId
     * @return
     */
    List<AppointmentNoticeDTO> selectAppointmentByDoctorId(String doctorId);

    /**
     * 查询医生的提醒消息
     * @param doctorId
     * @return
     */
    List<RemindNoticeDTO> selectRemindByDoctorId(String doctorId);

    /**
     * 查询医生某天的日程
     * @param doctorId
     * @param date
     * @return
     */
    List<ScheduleDTO> selectScheduleByDoctorId(String doctorId, String date);

    /**
     * 查询医生本周每天的预约量
     * @param doctorId
     * @param startDate
     * @param endDate
     * @return
     */
    List<WeekCustomerDataDTO> selectWeekAmount(String doctorId, String startDate, String endDate);

    /**
     * 查询医生本周的预约总数
     * @param doctorId
     * @param startDate
     * @param endDate
     * @return
     */
    int selectWeekTotal(String doctorId, String startDate, String endDate);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);
}