package com.morgan.manage.common.base;

import com.morgan.manage.common.utils.ShiroUtils;
import com.morgan.manage.system.model.SysUser;
import org.springframework.stereotype.Controller;

/**
 * @Author：Morgan.B.Chen
 * @Description: 基础控制器
 * @Date:2018/7/9
 */
@Controller
public class BaseController {

    public SysUser getUser() {
        return ShiroUtils.getUser();
    }

    public Integer getUserId() {
        return getUser().getId();
    }

    public String getUserName() {
        return getUser().getUserName();
    }
}
