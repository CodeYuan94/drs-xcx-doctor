package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.ComFunc;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.base.utils.DateUtils;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.AppointmentDao;
import com.df.drs.model.dto.schedule.ScheduleDTO;
import com.df.drs.model.entity.Appointment;
import com.df.drs.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    AppointmentDao appointmentDao;

    @Override
    public ResultBean<ScheduleDTO> findScheduleByDoctorId(String doctorId, Date date) {
        if (null == date) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL,"参数不能为空！");
        }
        String dateString = DateUtils.dateToString(date, "yyyy-MM-dd HH:mm:ss");
        List<ScheduleDTO> scheduleDTOS = appointmentDao.selectScheduleByDoctorId(doctorId, dateString);
        if (scheduleDTOS.isEmpty() || null == scheduleDTOS) {
            return ResultBean.success("查询成功,数据为空！",null);
        } else {
            return ResultBean.success("查询成功！",scheduleDTOS);
        }
    }

    @Override
    public ResultBean saveSchedule(ScheduleDTO scheduleDTO, String username) {
        Appointment appointment = CopyClassUtils.copyClassProperties(scheduleDTO, Appointment.class);
        String id = appointment.getId();

        if (StringUtils.isNullOrEmpty(id)) {
            appointment.setCreateUser(username);
            return insertSchedule(appointment);
        } else {
            Appointment appointment1 = appointmentDao.selectByPrimaryKey(id);
            if (null != appointment1) {
                if (StringUtils.isNotNullOrEmpty(appointment.getDoctorId()) && StringUtils.isNotNullOrEmpty(appointment.getPatientId())) {
                    return ResultBean.error(ErrorCode.CHANGE_ERROR, "此日程为预约日程，不可修改！");
                }
                appointment.setUpdateUser(username);
                return updateSchedule(appointment);
            } else {
                return ResultBean.error(ErrorCode.CHANGE_ERROR, "id错误");
            }
        }
    }

    @Override
    public ResultBean finishOrdeleteSchedule(String id, String username, int type) {
        Appointment appointment = appointmentDao.selectByPrimaryKey(id);
        if (appointment== null){
            return ResultBean.error(ErrorCode.PARAMETER_NULL,"未找到该日程");
        }
        appointment.setUpdateUser(username);
        ResultBean result = null;
        switch (type){
            case 0:
                appointment.setCompleted(0);
                result= updateSchedule(appointment);
                result.setMessage("修改成功");
                break;
            case 1:
                appointment.setCompleted(1);
                result= updateSchedule(appointment);
                result.setMessage("修改成功");
                break;
            case -1:
                appointment.setDelflag(1);
                result= updateSchedule(appointment);
                result.setMessage("删除成功");
                break;
        }
        return result;
    }

/** ===========================================================*/
    /** ====                      工        具                   ==*/
    /** ===========================================================*/
    /**
     * 修改 日程
     *
     * @param stoa
     * @return
     */
    private ResultBean updateSchedule(Appointment stoa) {
        stoa.setUpdateTime(new Date());
        int update = appointmentDao.updateByPrimaryKeySelective(stoa);
        if (update > 0) {
            return ResultBean.success("成功修改");
        }
        return ResultBean.error(ErrorCode.CHANGE_ERROR, "没有修改，或者修改失败");
    }

    /**
     * 添加日程使用
     *
     * @param stoa 日程
     * @return
     */
    private ResultBean insertSchedule(Appointment stoa) {
        stoa.setId(ComFunc.generateNo("AP"));
        stoa.setCreateTime(new Date());
        int insert = appointmentDao.insert(stoa);
        if (insert > 0) {
            return ResultBean.success("成功添加");
        }
        return ResultBean.error(ErrorCode.ADD_ERROR, "添加失败");
    }

//    /**
//     * 预约转换为 日程显示
//     *
//     * @param a 预约
//     * @return 日程
//     */
//    private List<ScheduleDTO> atos(List<Appointment> a) {
//        if (a == null || a.isEmpty()) {
//            return null;
//        }
//        List<ScheduleDTO> list = new ArrayList<>(a.size());
//        for (Appointment appointment : a) {
//            ScheduleDTO scheduleDTO = new ScheduleDTO();
//            BeanUtils.copyProperties(appointment, scheduleDTO);
//            list.add(scheduleDTO);
//        }
//        return list;
//    }
//
//    /**
//     * 日程 转换为 预约
//     *
//     * @param scheduleDTO 预约
//     * @return 日程
//     */
//    private Appointment stoa(ScheduleDTO scheduleDTO) {
//        if (scheduleDTO == null) {
//            return null;
//        }
//        Appointment appointment = new Appointment();
//        BeanUtils.copyProperties(scheduleDTO, appointment);
//        return appointment;
//    }
}
