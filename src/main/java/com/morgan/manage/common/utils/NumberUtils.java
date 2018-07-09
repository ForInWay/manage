package com.morgan.manage.common.utils;

import java.util.Random;

/**
 * @Author：Morgan.B.Chen
 * @Description: 数字工具类
 * @Date:2018/7/9
 */
public class NumberUtils {

    public static int getRandom(int number){
        return new Random().nextInt(number) + 1;
    }
}
