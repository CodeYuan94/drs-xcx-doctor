package com.df.drs.controller;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.model.dto.schedule.ScheduleDTO;
import com.df.drs.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 日程控制层
 *
 * @author liu
 * @date 2020年6月2日14:53:14
 */
@Api(value = "日程 Controller", tags = {"日程 接口"})
@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @ApiOperation(value = "查询 医生 日程")
    @GetMapping("/query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "doctorId", value = "医生id", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "date", value = "日期", paramType = "query", dataType = "date")
    })
    public ResultBean<ScheduleDTO> querySchedule(@RequestParam(required = false) String doctorId, @RequestParam(required = false) Date date) {
        if (StringUtils.isNullOrEmpty(doctorId) && null == date) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        return scheduleService.findScheduleByDoctorId(doctorId, date);
    }


    @ApiOperation(value = "添加或修改 日程 信息")
    @PostMapping("/save")
    public ResultBean saveSchedule(@RequestBody ScheduleDTO scheduleDTO, @ApiIgnore HttpSession session) {
        if (scheduleDTO == null) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        String username = (String) session.getAttribute("username");
        return scheduleService.saveSchedule(scheduleDTO, username);
    }

    @ApiOperation(value = "删除 日程 信息")
    @DeleteMapping("/del/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "日程id", paramType = "path", dataType = "string", required = true)
    })
    public ResultBean delSchedule(@PathVariable("id") String id, @ApiIgnore HttpSession session) {
        if (StringUtils.isNullOrEmpty(id)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        String username = (String) session.getAttribute("username");
        return scheduleService.finishOrdeleteSchedule(id, username, -1);
    }

    @ApiOperation(value = "标记 完成日程 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "日程id", paramType = "path", dataType = "string", required = true),
            @ApiImplicitParam(name = "type", value = "0 未完成  1 完成", paramType = "path", dataType = "int", required = true)
    })
    @PutMapping("/mark/{id}/{type}")
    public ResultBean finishSchedule(@PathVariable("type") int type, @PathVariable("id") String id, @ApiIgnore HttpSession session) {
        if (StringUtils.isNullOrEmpty(id)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        if (type != 1 && type != 0) {
            return ResultBean.error(ErrorCode.PARAMETER_TYPE_ERROR, ErrorCode.getMsg(ErrorCode.PARAMETER_TYPE_ERROR));
        }
        String username = (String) session.getAttribute("username");
        return scheduleService.finishOrdeleteSchedule(id, username, type);
    }
}