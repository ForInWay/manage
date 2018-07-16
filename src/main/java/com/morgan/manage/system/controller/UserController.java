package com.morgan.manage.system.controller;


import com.morgan.manage.common.base.BaseController;
import com.morgan.manage.common.utils.AjaxResult;
import com.morgan.manage.common.utils.DecriptUtils;
import com.morgan.manage.system.model.SysUser;
import com.morgan.manage.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author：Morgan.B.Chen
 * @Description: 用户管理控制器
 * @Date:2018/7/4
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * 跳转至修改密码页面
     * @return
     */
    @GetMapping("/changePwd")
    public ModelAndView changePwd(){
        ModelAndView model = new ModelAndView("changePwd");
        model.addObject("user",getUser());
        return model;
    }

    /**
     * 修改密码
     * @param password
     * @param oldPwd
     * @return
     */
    @PostMapping("/changePwd")
    @ResponseBody
    public AjaxResult changePwd(String password,String oldPwd){
        SysUser user = userService.find(getUserId());
        if (!user.getPassword().equals(DecriptUtils.MD5(oldPwd))){
            return AjaxResult.error("密码错误");
        }
        SysUser curUser = getUser();
        curUser.setPassword(DecriptUtils.MD5(password));
        if (userService.update(curUser)>0){
            return AjaxResult.ok("修改成功");
        }else{
            return AjaxResult.error("修改密码失败");
        }
    }
}
