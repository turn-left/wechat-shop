package com.ethen.wechatshop.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * cms系统
 */
@Controller
@RequestMapping("/cms")
public class CmsController {

    @RequestMapping(method = RequestMethod.GET)
    public Object index() {
        return "/cms/index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object user() {
        System.out.println("**********************");
        return "/cms/user";
    }

}
