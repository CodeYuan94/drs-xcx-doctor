package com.df.drs.base.annotation;

import com.df.drs.base.vaildor.DateVaildor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @program: sperm_donner
 * @description: 时间校验
 * @author: jzx
 * @create: 2019-10-22 15:49
 **/

@Constraint(validatedBy = DateVaildor.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateVail {

    String message() default "时间格式不合法";

    String formate() default "yyyy-MM-dd";

    boolean notNull() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
