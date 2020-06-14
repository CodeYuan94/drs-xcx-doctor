package com.df.drs.base.annotation;

import java.lang.annotation.*;

/**
 * 更新sql语句生成排他
 *
 * @author jiaozhixiang
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Exclude {

}
