package com.ethen.wechatshop.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册
 */
@Controller
@RequestMapping("/portal")
public class RegisterController {

    @RequestMapping("/register")
    public Object register(HttpServletRequest req, HttpServletResponse rsp) {
//        String user


        return "reg-result";
    }
}


//<tr>
//<td class="field">用户名：</td>
//<td><input class="text" type="text" name="userName" onfocus="FocusItem(this)"
//        onblur="CheckItem(this),check(this.value);"/><span id="sp"></span></td>
//</tr>
//<tr>
//<td class="field">姓名：</td>
//<td><input type="text" class="text" name="name"/></td>
//</tr>
//<tr>
//<td class="field">登录密码：</td>
//<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)"
//        onblur="CheckItem(this);"/><span></span></td>
//</tr>
//<tr>
//<td class="field">确认密码：</td>
//<td><input class="text" type="password" name="rePassWord" onfocus="FocusItem(this)"
//        onblur="CheckItem(this);"/><span></span></td>
//</tr>
//<tr>
//<td class="field">性别：</td>
//<td><input type="radio" name="sex" value="T" checked="checked"/>男
//<input type="radio" name="sex" value="F"/>女
//</td>
//</tr>
//<tr>
//<td class="field">出生日期：</td>
//<td>
//<input type="text" name="birthday" onfocus="c.showMoreDay = false;c.show(this);"/>
//</td>
//</tr>
//<tr>
//<td class="field">邮箱：</td>
//<td><input type="text" class="text" name="email" value=""/></td>
//</tr>
//<tr>
//<td class="field">手机号码：</td>
//<td><input type="text" class="text" name="mobile" value=""  onfocus="FocusItem(this)" onblur="CheckItem(this)"/>
//<span></span>
//</td>
//</tr>
//<tr>
//<td class="field">收件地址：</td>
//<td><input type="text" class="text" name="address" value=""/></td>
//</tr>