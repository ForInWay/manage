package com.morgan.manage.system.controller;

import com.morgan.manage.common.base.BaseController;
import com.morgan.manage.common.utils.AjaxResult;
import com.morgan.manage.common.utils.NumberUtils;
import com.morgan.manage.common.base.model.Node;
import com.morgan.manage.system.model.SysUser;
import com.morgan.manage.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
 * @Description: 登录控制器
 * @Date:2018/7/4
 */
@RequestMapping("/api/user")
@Controller
public class LoginController extends BaseController{

    @Autowired
    private MenuService menuService;

    /**
     * 跳转至登录页面
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView model = new ModelAndView("login");
        String bgImage = "/static/local/images/bg" + NumberUtils.getRandom(5) + "-login.jpg";
        model.addObject("bgImage", bgImage);
        return model;
    }

    /**
     * 登录验证
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String login(SysUser user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "redirect:home";
    }

    /**
     * 跳转至首页
     * @return
     */
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home");
        List<Node> menus = menuService.findMenusByUserId(getUserId());
        model.addObject("menus",menus);
        return model;
    }
}

