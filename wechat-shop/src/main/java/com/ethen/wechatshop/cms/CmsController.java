package com.ethen.wechatshop.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * cms系统实现一些页面的跳转
 */
@Controller
@RequestMapping("/cms")
public class CmsController {

    public static final String CMS_INDEX = "/cms/index";
    public static final String CMS_USER = "/cms/user";
    public static final String CMS_PRODUCT = "/cms/product";
    public static final String CMS_BOOK = "/cms/guestbook";
    public static final String CMS_ORDER = "/cms/order";
    public static final String CMS_NEWS = "/cms/news";

    @RequestMapping(method = RequestMethod.GET)
    public Object index() {
        return CMS_INDEX;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object user() {
        return CMS_USER;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Object product() {
        return CMS_PRODUCT;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Object order() {
        return CMS_ORDER;
    }


    @RequestMapping(value = "/guestbook", method = RequestMethod.GET)
    public Object guestbook() {
        return CMS_BOOK;
    }


    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public Object news() {
        return CMS_NEWS;
    }


}
