package com.morgan.manage.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author：Morgan.B.Chen
 * @Description: 登录控制器
 * @Date:2018/7/4
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView model = new ModelAndView("/");
        return model;
    }


}
