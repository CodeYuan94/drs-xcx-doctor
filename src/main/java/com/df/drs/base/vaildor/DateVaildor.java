package com.df.drs.base.vaildor;

import com.df.drs.base.annotation.DateVail;
import com.df.drs.base.utils.DateUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @program: sperm_donner
 * @description: 时间校验
 * @author: jzx
 * @create: 2019-10-22 15:47
 **/
public class DateVaildor implements ConstraintValidator<DateVail,String> {

    private String formate;

    private boolean notNull = true;

    @Override
    public void initialize(DateVail constraintAnnotation) {
        formate = constraintAnnotation.formate();
        notNull = constraintAnnotation.notNull();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(null == value){
            return !notNull;
        }
        return DateUtils.checkFromat(value,formate);
    }
}
