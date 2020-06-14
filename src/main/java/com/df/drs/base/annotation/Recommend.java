package com.df.drs.base.annotation;

import java.lang.annotation.*;

/**
 * 用于修改字符按介绍
 *
 * @author zhaoxy
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Recommend {
    //字段描述
    String recommend() default "";

    //可否为空 0 可以 其他不可
    boolean noNull() default false;

    //设置时间转换格式
    String format() default "yyyy-MM-dd";

    //对应数据库名称
    String col() default "";

    //判定同一数据标记
    boolean isMark() default false;
}
