package com.df.drs.model.dto.doctor;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 * @project drs
 * @description 部门DTO
 * @date 2020/6/10 9:07
 **/
@Data
public class DepartmentDTO implements Serializable {

    private static final long serialVersionUID = -7345220449559994077L;

    /**
     * id
     */
    private String id;

    /**
     * 科室名
     */
    private String name;
}
