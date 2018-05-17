package com.ethen.wechatshop.cart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 购物车跳转基本控制器
 */
@Controller
@RequestMapping("/shopping")
public class CartDispatchController {

    @RequestMapping(method = RequestMethod.GET)
    public Object shopping() {
        return "shopping";
    }
}
