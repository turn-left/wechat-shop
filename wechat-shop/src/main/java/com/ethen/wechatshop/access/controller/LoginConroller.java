package com.ethen.wechatshop.access.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginConroller {

    @RequestMapping(method = RequestMethod.POST)
    public Object login(@RequestParam("accName") String accountName,@RequestParam("accPassWord") String password){

        System.err.println("accountName:"+accountName);
        System.err.println("password:"+password);
        return null;
    }



    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        Map<String,Object> testMap = new HashMap<>();
        testMap.put("CODE","0000");
        testMap.put("MSG","success!");
        return "login";
    }
}
