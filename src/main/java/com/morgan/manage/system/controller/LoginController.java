package com.morgan.manage.system.controller;

import com.morgan.manage.common.utils.AjaxResult;
import com.morgan.manage.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：Morgan.B.Chen
 * @Description: 登录控制器
 * @Date:2018/7/4
 */
@RequestMapping("/api/user")
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public void login(User user){
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/home")
    public AjaxResult home(){
        AjaxResult result = new AjaxResult();
        return result;
    }
}

