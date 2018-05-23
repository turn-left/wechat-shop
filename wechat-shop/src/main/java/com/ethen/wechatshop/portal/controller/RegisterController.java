package com.ethen.wechatshop.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注册
 */
@Controller
@RequestMapping("/portal")
public class RegisterController {

    @RequestMapping("/register")
    public Object register() {

        return "reg-result";
    }
}
