package com.ethen.wechatshop.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * portal模块实现简单界面跳转
 */
@Controller
@RequestMapping("/portal")
public class PortalDispatchController {

    @RequestMapping("/toRegister")
    public Object toRegister() {
        return "register2";
    }

    @RequestMapping("/toLogin")
    public Object toLogin() {
        return "login";
    }

    @RequestMapping("/toGuestbook")
    public Object toGuestbook() {
        return "guestbook";
    }
}
