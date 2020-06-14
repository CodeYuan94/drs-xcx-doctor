package com.df.drs.base.annotation;

import java.lang.annotation.*;

/**
 * 用于修改字符按介绍
 *
 * @author zhaoxy
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableField {
    //字段描述
    String name() default "";

}
