package com.ethen.wechatshop.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 订单模块界面跳转
 */
@Controller
@RequestMapping("/order")
public class OrderDispatchController {

    @RequestMapping(value = "selfOrder",method = RequestMethod.GET)
    public Object toSelfOrder() {
        return "selfOrder";
    }
}
