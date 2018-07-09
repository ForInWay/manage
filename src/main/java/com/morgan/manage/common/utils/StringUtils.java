package com.morgan.manage.common.utils;

/**
 * @Author：Morgan.B.Chen
 * @Description: 字符串工具类
 * @Date:2018/7/6
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return !(str!=null && str.trim().length()!=0);
    }
}
