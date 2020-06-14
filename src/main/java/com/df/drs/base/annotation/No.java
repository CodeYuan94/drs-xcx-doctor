package com.df.drs.base.annotation;

import java.lang.annotation.*;

/**
 * 更新表作为主键记录
 *
 * @author jiaozhixiang
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface No {
    boolean isAuto() default false;
}
