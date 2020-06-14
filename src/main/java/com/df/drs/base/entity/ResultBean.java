package com.df.drs.base.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Liu Yaoguang
 * @Classname aaa
 * @Description
 * @Date 2019/12/06 09:22
 */
@Data
public class ResultBean<T> {

    @ApiModelProperty(value = "返回码",dataType = "int")
    private int code;

    @ApiModelProperty(value = "返回描述信息",dataType = "string")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    @ApiModelProperty(value = "口令",dataType = "string")
    private String token;

    private ResultBean() {

    }

    public static ResultBean error(int code, String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        return resultBean;
    }
    public static<T> ResultBean error(int code, String message, T data) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        resultBean.setData(data);
        return resultBean;
    }

    public static ResultBean success(String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMessage(message);
        return resultBean;
    }

    public static<T> ResultBean success(String message, T data) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setCode(200);
        resultBean.setMessage(message);
        resultBean.setData(data);
        return resultBean;
    }
    public static <T> ResultBean success(String message, T data, String token) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.setCode(200);
        resultBean.setMessage(message);
        resultBean.setData(data);
        resultBean.setToken(token);
        return resultBean;
    }

}