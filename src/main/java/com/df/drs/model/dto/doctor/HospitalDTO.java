package com.df.drs.model.dto.doctor;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 医院DTO
 * @date 2020/6/9 18:47
 **/
@Data
public class HospitalDTO implements Serializable {

    private static final long serialVersionUID = 4330955438992171052L;

    /**
     * id
     */
    private String id;

    /**
     * 医院名
     */
    private String name;
}
