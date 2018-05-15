package com.ethen.wechatshop.access.controller;

import com.ethen.wechatshop.access.service.LoginService;
import com.ethen.wechatshop.access.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginConroller {

    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestParam String userName, @RequestParam String passWord,
                        @RequestParam(required = false) String veriCode, Model model) {
        System.err.println("accountName:" + userName);
        System.err.println("password:" + passWord);
        System.err.println("veriCode:" + veriCode);
        //todo 验证码处理

        User userInfo = loginService.login(userName, passWord);
        if (null != userInfo && !StringUtils.isEmpty(userInfo.getUserName())) {
            model.addAttribute("userInfo",userInfo);
            return "index";
        } else {
            return "login";
        }
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        Map<String, Object> testMap = new HashMap<>();
        testMap.put("CODE", "0000");
        testMap.put("MSG", "success!");
        return "index";
    }
}
