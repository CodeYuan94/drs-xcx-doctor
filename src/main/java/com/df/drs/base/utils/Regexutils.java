package com.df.drs.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname VerificationUtils
 * @Description
 * @Date 2019/11/20 9:13
 * @author Liu Yaoguang
 */
public class Regexutils {


    private Regexutils(){

    }

    /**
     *@auther Liu Yaoguang
     *@Description      验证方法
     * @param pattern
     * @param str
     *@return boolean
     *@date 2019/11/20 9:12
     */
    public static boolean isTrue(Pattern pattern, String str){
        boolean flag = false;
        try{
            Matcher m = pattern.matcher(str);
            flag = m.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }
}
