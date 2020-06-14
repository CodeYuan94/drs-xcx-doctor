package com.df.drs.model.dto.patient;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 患者名片DTO
 * @date 2020/6/2 18:10
 **/
@Data
public class PatientCardDTO implements Serializable {

    private static final long serialVersionUID = 8938667243306131484L;

    /**
     * id
     */
    private String id;
    /**
     * 患者个人资料dto
     */
    private PatientDTO patientDTO;

    /**
     * 月经史dto
     */
    private List<MenstruationHistoryDTO> menstruationHistoryDTOList;

    /**
     * 婚育史dto
     */
    private List<MarriageHistoryDTO> marriageHistoryDTOList;

    /**
     * 既往史dto
     */
    private PastHistoryDTO pastHistoryDTO;

    /**
     * 家族史dto
     */
    private FamilyHistoryDTO familyHistoryDTO;

    /**
     * 患者标签dto
     */
    private List<PatientLabelConfigDTO> patientLabelConfigDTOS;

    /**
     * 患者上传资料dto
     */
    private List<PatientUploadDTO> patientUploadDTOList;
}
