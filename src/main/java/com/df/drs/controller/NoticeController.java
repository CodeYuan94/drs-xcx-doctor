package com.df.drs.controller;

import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.model.dto.notice.AppointmentNoticeDTO;
import com.df.drs.model.dto.notice.RemindNoticeDTO;
import com.df.drs.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan
 * @project drs-xcx-doctor
 * @description 通知controller
 * @date 2020/6/11 15:18
 **/
@RestController
@RequestMapping("notice")
@Api(value = "通知 controller", tags = "通知 接口")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/appointment/{doctorId}")
    @ApiOperation("查看 医生 预约通知")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "doctorId", value = "医生id", paramType = "path", dataType = "string",required = true)
    )
    public ResultBean<AppointmentNoticeDTO> findAppointmentNotice (@PathVariable("doctorId") String doctorId) {
        if (StringUtils.isNullOrEmpty(doctorId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        return noticeService.findAppointmentNoticeDTO(doctorId);
    }


    @GetMapping("/remind/{doctorId}")
    @ApiOperation("查看 医生 提醒通知")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "doctorId", value = "医生id", paramType = "path", dataType = "string",required = true)
    )
    public ResultBean<RemindNoticeDTO> findRemindNotice(@PathVariable("doctorId") String doctorId) {
        if (StringUtils.isNullOrEmpty(doctorId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        return noticeService.findRemindNoticeDTO(doctorId);
    }
}
