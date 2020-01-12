package com.wchat.secondhand.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/* 记住你的端口的设计需要基于restful 接口进行设计 */
/*
* 面向资源进行操作
*
*
*
* */

@Controller
public class UserController {
    @Autowired
    UserService service;

    @ResponseBody
    @PostMapping(value = "/user")
    public void queryUser(@RequestBody String code){
        String appId = new String("2343242");
        String appSecretId = new String("123");
        service.getUser(code, appId, appSecretId); // 获取用户的openid， session_key
    }
}
