package com.ethen.wechatshop.cms.controller;

import com.ethen.wechatshop.cms.service.UserService;
import com.ethen.wechatshop.portal.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * cms用户相关控制器
 * todo 带加入相关权限控制
 */
@Controller
@RequestMapping("/cms/user")
public class UserController {
    @Autowired
    UserService userService;

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/findAll")
    public Object findAll(Model model) {
        List<User> userList = userService.findAll();
        int totalCount = userService.findTotalCount();
        log.info("UserController findAll userList:" + userList);
        model.addAttribute("userList", userList);
        return "cms/user";
    }
}
