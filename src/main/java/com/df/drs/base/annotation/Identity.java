package com.df.drs.base.annotation;

import java.lang.annotation.*;

/**
 * 识别相同数据标志
 *
 * @author jiaozhixiang
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Identity {
}
