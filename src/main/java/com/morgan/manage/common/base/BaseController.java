package com.morgan.manage.common.base;

import com.morgan.manage.common.utils.ShiroUtils;
import com.morgan.manage.system.model.User;
import org.springframework.stereotype.Controller;

/**
 * @Author：Morgan.B.Chen
 * @Description: 基础控制器
 * @Date:2018/7/9
 */
@Controller
public class BaseController {
    public User getUser() {
        return ShiroUtils.getUser();
    }

    public Integer getUserId() {
        return getUser().getId();
    }

    public String getUserName() {
        return getUser().getUserName();
    }
}
