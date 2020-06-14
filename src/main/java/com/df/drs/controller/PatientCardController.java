package com.df.drs.controller;

import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.model.dto.patient.MedicalRecordDTO;
import com.df.drs.model.dto.patient.PatientCardDTO;
import com.df.drs.service.PatientCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan
 * @project drs-xcx-doctor
 * @description 患者名片controller
 * @date 2020/6/11 15:41
 **/
@RestController
@Api(value = "患者名片 controller", tags = "患者名片 接口")
public class PatientCardController {

    @Autowired
    private PatientCardService patientCardService;

    @GetMapping("patientInfo/{patientId}")
    @ApiOperation("查看 患者 个人资料")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "patientId", value = "患者id",paramType = "path",dataType = "string",required = true)
    )
    public ResultBean<PatientCardDTO> findPatientInfo(@PathVariable("patientId") String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        return patientCardService.findPatientInfo(patientId);
    }

    @GetMapping("MedicalRecord/{patientId}")
    @ApiOperation("查看 患者 就诊履历")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "patientId", value = "患者id",paramType = "path",dataType = "string",required = true)
    )
    public ResultBean<MedicalRecordDTO> findMedicalRecord(@PathVariable("patientId") String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, ErrorCode.getMsg(ErrorCode.PARAMETER_NULL));
        }
        return patientCardService.findMedicalRecord(patientId);
    }
}
