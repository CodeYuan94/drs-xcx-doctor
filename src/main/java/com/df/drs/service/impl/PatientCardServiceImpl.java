package com.df.drs.service.impl;


import com.df.drs.base.common.ErrorCode;
import com.df.drs.base.entity.ResultBean;
import com.df.drs.base.utils.CopyClassUtils;
import com.df.drs.base.utils.StringUtils;
import com.df.drs.dao.*;
import com.df.drs.model.dto.patient.*;
import com.df.drs.model.entity.*;
import com.df.drs.service.PatientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 患者名片service实现
 * @date 2020/6/3 9:12
 **/
@Service
public class PatientCardServiceImpl implements PatientCardService {

    /**
     * 患者资料dao
     */
    @Autowired
    private PatientDao patientDao;

    /**
     * 月经史dao
     */
    @Autowired
    private MenstruationHistoryDao menstruationHistoryDao;

    /**
     * 婚育史dao
     */
    @Autowired
    private MarriageHistoryDao marriageHistoryDao;

    /**
     * 既往史dao
     */
    @Autowired
    private PastHistoryDao pastHistoryDao;

    /**
     * 家族史dao
     */
    @Autowired
    private FamilyHistoryDao familyHistoryDao;

    /**
     * 患者标签dao
     */
    @Autowired
    private PatientLabelDao patientLabelDao;

    /**
     * 患者上传资料dao
     */
    @Autowired
    private PatientUploadDao patientUploadDao;

    /**
     * 患者就诊履历dao
     */
    @Autowired
    private MedicalRecordDao medicalRecordDao;


    @Override
    public ResultBean<PatientCardDTO> findPatientInfo(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, "参数不能为空！");
        }
        // 患者资料dto
        Patient patient = patientDao.selectByPrimaryKey(patientId);
        PatientDTO patientDTO = CopyClassUtils.copyClassProperties(patient, PatientDTO.class);
        // 月经史dto
        List<MenstruationHistory> menstruationHistories = menstruationHistoryDao.selectByPatientId(patientId);
        List<MenstruationHistoryDTO> menstruationHistoryDTOS = CopyClassUtils.copyListProperties(menstruationHistories, MenstruationHistoryDTO.class);
        // 婚育史dto
        List<MarriageHistory> marriageHistories = marriageHistoryDao.selectByPatientId(patientId);
        List<MarriageHistoryDTO> marriageHistoryDTOS = CopyClassUtils.copyListProperties(marriageHistories, MarriageHistoryDTO.class);
        // 既往史dto
        List<PastHistory> pastHistories = pastHistoryDao.selectByPatientId(patientId);
        if (null == pastHistories || pastHistories.isEmpty()) {
            return ResultBean.success("查询成功，既往史数据为空！", null);
        } else {
            // 既往史
            PastHistoryDTO pastHistorDTO = new PastHistoryDTO();
            // 男方既往史集合
            List<PastHistoryMaleDTO> pastHistoryMaleDTOS = new ArrayList<>();
            // 女方既往史集合
            List<PastHistoryFemaleDTO> pastHistoryFemaleDTOS = new ArrayList<>();

            for (PastHistory pastHistory : pastHistories) {
                int delflag = pastHistory.getDelflag();
                if (delflag == 0) {
                    // 0 男方既往史
                    PastHistoryMaleDTO pastHistoryMaleDTO = CopyClassUtils.copyClassProperties(pastHistory, PastHistoryMaleDTO.class);
                    pastHistoryMaleDTOS.add(pastHistoryMaleDTO);
                    pastHistorDTO.setPastHistoryMaleDTOS(pastHistoryMaleDTOS);
                } else if (delflag == 1) {
                    // 1 女方既往史
                    PastHistoryFemaleDTO pastHistoryFemaleDTO = CopyClassUtils.copyClassProperties(pastHistory, PastHistoryFemaleDTO.class);
                    pastHistoryFemaleDTOS.add(pastHistoryFemaleDTO);
                    pastHistorDTO.setPastHistoryFemaleDTOS(pastHistoryFemaleDTOS);
                } else {
                    return ResultBean.error(ErrorCode.QUERY_ERROR, "男女方标记错误！");
                }
            }


            // 家族史dto
            List<FamilyHistory> familyHistories = familyHistoryDao.selectByPatientId(patientId);
            if (null == familyHistories || familyHistories.isEmpty()) {
                return ResultBean.success("查询成功，家族史数据为空！", null);
            } else {
                // 家族史
                FamilyHistoryDTO familyHistoryDTO = new FamilyHistoryDTO();
                // 男方家族史集合
                List<FamilyHistoryMaleDTO> familyHistoryMaleDTOS = new ArrayList<>();
                // 女方家族史集合
                List<FamilyHistoryFemaleDTO> familyHistoryFemaleDTOS = new ArrayList<>();
                for (FamilyHistory familyHistory : familyHistories) {
                    int delflag = familyHistory.getDelflag();
                    if (delflag == 0) {
                        // 0 男方
                        FamilyHistoryMaleDTO familyHistoryMaleDTO = CopyClassUtils.copyClassProperties(familyHistory, FamilyHistoryMaleDTO.class);
                        familyHistoryMaleDTOS.add(familyHistoryMaleDTO);
                        familyHistoryDTO.setFamilyHistoryMaleDTOS(familyHistoryMaleDTOS);
                    } else if (delflag == 1) {
                        // 1 女方
                        FamilyHistoryFemaleDTO familyHistoryFemaleDTO = CopyClassUtils.copyClassProperties(familyHistory, FamilyHistoryFemaleDTO.class);
                        familyHistoryFemaleDTOS.add(familyHistoryFemaleDTO);
                        familyHistoryDTO.setFamilyHistoryFemaleDTOS(familyHistoryFemaleDTOS);
                    } else {
                        return ResultBean.error(ErrorCode.QUERY_ERROR, "男女方标记错误！");
                    }
                }


                // 患者上传资料
                List<PatientUpload> patientUploads = patientUploadDao.selectByPatientId(patientId);
                List<PatientUploadDTO> patientUploadDTOS = CopyClassUtils.copyListProperties(patientUploads, PatientUploadDTO.class);
                // 患者标签
                List<PatientLabelConfigDTO> patientLabelConfigDTOS = patientLabelDao.selectNameByPatientId(patientId);

                PatientCardDTO patientCardDTO = new PatientCardDTO();
                patientCardDTO.setPatientDTO(patientDTO);
                patientCardDTO.setMenstruationHistoryDTOList(menstruationHistoryDTOS);
                patientCardDTO.setMarriageHistoryDTOList(marriageHistoryDTOS);
                patientCardDTO.setPastHistoryDTO(pastHistorDTO);
                patientCardDTO.setFamilyHistoryDTO(familyHistoryDTO);
                patientCardDTO.setPatientUploadDTOList(patientUploadDTOS);
                patientCardDTO.setPatientLabelConfigDTOS(patientLabelConfigDTOS);
                return ResultBean.success("获取患者名片成功！", patientCardDTO);
            }
        }
    }

    @Override
    public ResultBean<MedicalRecordDTO> findMedicalRecord(String patientId) {
        if (StringUtils.isNullOrEmpty(patientId)) {
            return ResultBean.error(ErrorCode.PARAMETER_NULL, "参数不能为空！");
        }
        List<MedicalRecordDTO> medicalRecordDTOS = medicalRecordDao.selectByPatientId(patientId);
        return ResultBean.success("获取就诊履历成功！",medicalRecordDTOS);
    }
}