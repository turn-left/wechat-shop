package com.ethen.wechatshop.cms.controller;

import com.ethen.wechatshop.cms.service.CmsService;
import com.ethen.wechatshop.cms.service.UserService;
import com.ethen.wechatshop.order.service.OrderService;
import com.ethen.wechatshop.portal.vo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static com.ethen.wechatshop.cms.common.Constant.*;
import java.util.List;
import java.util.Map;

/**
 * cms系统实现一些页面的跳转
 */
@Controller
@RequestMapping("/cms")
public class CmsController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    CmsService cmsService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    public Object index() {
        return CMS_INDEX;
    }

    /**
     * 显示当前权限可查所有用户
     * todo 待加入权限及分页信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Object user(Model model) {
        List<User> userList = userService.findAll();
        log.info("UserController findAll userList:" + userList);
        model.addAttribute("userList", userList);
        return CMS_USER;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Object product(Model model) {
        Map<String,Object> retMap = cmsService.findProductList();
        model.addAttribute("productList",retMap.get("productList"));
        return CMS_PRODUCT;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Object order(Model model) {
        Map<String,Object> retMap = orderService.findOrderList();
        model.addAttribute("orderList",retMap.get("orderList"));
        return CMS_ORDER;
    }


    @RequestMapping(value = "/guestbook", method = RequestMethod.GET)
    public Object guestbook(Model model) {
        Map<String,Object> retMap = cmsService.findCommentList();
        model.addAttribute("commentList",retMap.get("commentList"));
        return CMS_BOOK;
    }


    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public Object news(Model model) {
        Map<String,Object> retMap = cmsService.findNewsList();
        model.addAttribute("newsList",retMap.get("newsList"));
        return CMS_NEWS;
    }

    @RequestMapping(value = "/productClass", method = RequestMethod.GET)
    public Object productClass(Model model) {
        Map<String,Object> retMap = cmsService.findProductClassList();
        model.addAttribute("productClassList",retMap.get("productClassList"));
        return CMS_PRODUCT_CLASS;
    }


}
