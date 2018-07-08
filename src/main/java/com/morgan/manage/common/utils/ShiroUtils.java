package com.morgan.manage.common.utils;

import com.morgan.manage.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @Author:morgan.b.chen
 * @Description: shiro工具類
 * @Date:2018/7/8
 */
public class ShiroUtils {

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    public static User getUser() {
        Object object = getSubjct().getPrincipal();
        return (User)object;
    }

    public static Integer getUserId() {
        return getUser().getId();
    }

    public static void logout() {
        getSubjct().logout();
    }
}
