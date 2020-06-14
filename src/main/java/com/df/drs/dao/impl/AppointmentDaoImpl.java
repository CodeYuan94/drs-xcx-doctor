package com.df.drs.dao.impl;


import com.df.drs.base.dao.BaseDao;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.AppointmentDao;
import com.df.drs.model.dto.count.WeekCustomerDataDTO;
import com.df.drs.model.dto.notice.AppointmentNoticeDTO;
import com.df.drs.model.dto.notice.RemindNoticeDTO;
import com.df.drs.model.dto.schedule.ScheduleDTO;
import com.df.drs.model.entity.Appointment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public class AppointmentDaoImpl extends BaseDao implements AppointmentDao {


    public AppointmentDaoImpl(){
        super();
        url ="com.df.drs.dao.AppointmentDao.";
    }
    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Appointment record) {
        return this.getSqlSession().insert(url+"insert",record);
    }

    @Override
    public int insertSelective(Appointment record) {
        return this.getSqlSession().insert(url+"insertSelective",record);
    }

    @Override
    public Appointment selectByPrimaryKey(String id) {
        return this.getSqlSession().selectOne(url+"selectByPrimaryKey",id);
    }


    @Override
    public List<AppointmentNoticeDTO> selectAppointmentByDoctorId(String doctorId) {
        return this.getSqlSession().selectList(url+"selectAppointmentByDoctorId",doctorId);
    }

    @Override
    public List<RemindNoticeDTO> selectRemindByDoctorId(String doctorId) {
        return this.getSqlSession().selectList(url+"selectRemindByDoctorId");
    }

    @Override
    public List<ScheduleDTO> selectScheduleByDoctorId(String doctorId, String date) {
        HashMap<String, String> map = new HashMap<>();
        if (StringUtils.isNullOrEmpty(doctorId)) {
            map.put("doctorId",doctorId);
        }
        if (StringUtils.isNullOrEmpty(date)) {
            map.put("date",date);
        }
        return this.getSqlSession().selectList(url+"selectScheduleByDoctorId",map);
    }

    @Override
    public List<WeekCustomerDataDTO> selectWeekAmount(String doctorId, String startDate, String endDate) {
        HashMap<String,String> map = new HashMap<>();
        if (StringUtils.isNullOrEmpty(doctorId)) {
            map.put("doctorId",doctorId);
        }
        if (StringUtils.isNullOrEmpty(startDate)) {
            map.put("startDate",startDate);
        }
        if (StringUtils.isNullOrEmpty(endDate)) {
            map.put("endDate",endDate);
        }
        return this.getSqlSession().selectList(url+"selectWeekAmount",map);
    }

    @Override
    public int selectWeekTotal(String doctorId, String startDate, String endDate) {
        HashMap<String,String> map = new HashMap<>();
        if (StringUtils.isNullOrEmpty(doctorId)) {
            map.put("doctorId",doctorId);
        }
        if (StringUtils.isNullOrEmpty(startDate)) {
            map.put("startDate",startDate);
        }
        if (StringUtils.isNullOrEmpty(endDate)) {
            map.put("endDate",endDate);
        }
        return this.getSqlSession().selectOne(url+"selectWeekTotal",map);
    }

    @Override
    public int updateByPrimaryKeySelective(Appointment record) {
        return this.getSqlSession().update(url+"updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(Appointment record) {
        return this.getSqlSession().update(url+"updateByPrimaryKey",record);
    }
}
