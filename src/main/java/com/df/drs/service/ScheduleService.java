package com.df.drs.service;


import com.df.drs.base.entity.ResultBean;
import com.df.drs.model.dto.schedule.ScheduleDTO;

import java.util.Date;

public interface ScheduleService {


    /**
     * 查询医生的日程
     * @param doctorId
     * @param date
     * @return
     */
    ResultBean<ScheduleDTO> findScheduleByDoctorId(String doctorId, Date date);

    /**
     * 保存  ：添加 修改
     * @param scheduleDTO  页面数据
     * @param username 登录用户名
     * @return
     */
    ResultBean saveSchedule(ScheduleDTO scheduleDTO, String username);


    /**
     * 标记完成，或者删除
     * @param id               日程id
     * @param username         登陆者
     * @param type             0 未完成      1 完成      -1  删除
     * @return
     */
    ResultBean finishOrdeleteSchedule(String id,String username,int type);


}
