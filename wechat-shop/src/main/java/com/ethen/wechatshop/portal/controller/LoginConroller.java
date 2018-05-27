package com.ethen.wechatshop.portal.controller;

import com.ethen.wechatshop.common.ResponseVo;
import com.ethen.wechatshop.portal.PortalConstant;
import com.ethen.wechatshop.portal.authnew.JWT;
import com.ethen.wechatshop.portal.service.LoginService;
import com.ethen.wechatshop.portal.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("/portal")
public class LoginConroller {

    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestParam String userName, @RequestParam String passWord,
                        @RequestParam(required = false) String veriCode, Model model,
                        HttpServletRequest request,HttpServletResponse response) {
        System.err.println("accountName:" + userName);
        System.err.println("password:" + passWord);
        System.err.println("veriCode:" + veriCode);
        //todo 验证码处理
        User userInfo = loginService.login(userName, passWord);
        //验证通过构造jwt
        if (null != userInfo && !StringUtils.isEmpty(userInfo.getUserName())) {
//            model.addAttribute("userInfo", userInfo);
            String token = JWT.sign(userInfo,60 * 1000 * 30L);
//            model.addAttribute("loginId",userName);
//            model.addAttribute("token",token);
            model.addAttribute("userInfo",userInfo);//fixme 信息范围 ??
            System.err.println("登录成功生成token："+ token);
            //将token保存到cookie中 fixme 如果禁用cookie如何处理？？
            Cookie tkCookie = new Cookie(PortalConstant.JWT_KEY,token);
            Cookie idCookie = new Cookie(PortalConstant.LOGIN_ID,userName);
            //设置cookie失效时间,默认为退出浏览器失效
            tkCookie.setMaxAge(PortalConstant.COOKIE_EX);
            response.addCookie(tkCookie);
            response.addCookie(idCookie);
            return "index";
        } else {
            ResponseVo rsp = new ResponseVo();
            rsp.setCode(101);
            rsp.setMsg("用户名或密码错误！");
            model.addAttribute("response",rsp);
            return "login";
        }
    }

    /**
     * 登出,注销cookie token等信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/portal/logout",method = RequestMethod.GET)
    public Object logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (PortalConstant.JWT_KEY.equals(cookie.getName()) || PortalConstant.LOGIN_ID.equals(cookie.getName()) ) {
                cookie.setValue(null);
                cookie.setMaxAge(0);    //立即销毁cookie
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
        return "login";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        Map<String, Object> testMap = new HashMap<>();
        testMap.put("CODE", "0000");
        testMap.put("MSG", "success!");
        return "index";
    }

    /**
     * 简单页面跳转
     * @return
     */
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }
}
