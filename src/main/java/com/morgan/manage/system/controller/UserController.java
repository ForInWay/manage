package com.morgan.manage.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

import java.util.List;

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

    /**
     * 跳转至用户列表界面
     * @return
     */
    @GetMapping("/page")
    public String findUserPage(){
        return "system/user/user";
    }

    /**
     * 分页获取用户列表
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public AjaxResult findUserList(int page,int limit){
        PageHelper.startPage(page,limit);
        List<SysUser> users = userService.list();
        PageInfo<SysUser> pageInfo = new PageInfo<>(users);
        return AjaxResult.ok(pageInfo.getTotal(),users);
    }
}
