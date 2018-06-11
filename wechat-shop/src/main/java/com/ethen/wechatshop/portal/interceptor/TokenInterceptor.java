package com.ethen.wechatshop.portal.interceptor;

import com.ethen.wechatshop.cms.vo.CmsUser;
import com.ethen.wechatshop.common.ResponseEnum;
import com.ethen.wechatshop.common.ResponseVo;
import com.ethen.wechatshop.portal.PortalConstant;
import com.ethen.wechatshop.portal.authnew.JWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * Note: SpringBoot实现自定义拦截器方法：
 * <ul>
 * <li>第一步创建一个类实现HandlerInterceptor接口，重写接口的方法，
 * 只是多了一个@Component注解，这个注解是为后面的使用时进行注入</li>
 * <li>第二步在入口类的目录或者兄弟目录下创建一个类继承WebMvcConfigurerAdapter类并重写addInterceptors方法</li>
 * </ul>
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = "";
        String loginId = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (PortalConstant.JWT_KEY.equals(cookie.getName())) {
                    token = cookie.getValue();
                } else if (PortalConstant.LOGIN_ID.equals(cookie.getName())) {
                    loginId = cookie.getValue();
                }
            }
            if (!StringUtils.isEmpty(token)) {
                CmsUser user = JWT.unsign(token, CmsUser.class);
                if (null != user && null != loginId) {
                    if (loginId.equals(user.getUserName())) {
                        //封装用户信息
                        CmsUser userInfo = new CmsUser();
                        userInfo.setUserName(loginId);
                        userInfo.setStatus(user.getStatus());
                        request.setAttribute("userInfo", userInfo);
                        return true;

                    }
                }
            }
        }

//        responseMessage(response, response.getWriter(), ResponseEnum.HTTP_FBD);
        response.sendRedirect("/portal/toLogin");//重定向到登录页
        return false;
    }


    /**
     * note: 在后处理中加上当前cms用户的信息 (fixme 当前是一种粗糙的做法,待改进)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object userInfo = request.getAttribute("userInfo");
        System.err.println("modelAndView=" + modelAndView);
        if (modelAndView !=null && userInfo != null) {
            modelAndView.addObject("userInfo", userInfo);
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseEnum responseEnum) throws JsonProcessingException {
        response.setContentType("application/json; charset=utf-8");
        ResponseVo responseVo = ResponseVo.fail(responseEnum);
        String json = new ObjectMapper().writeValueAsString(responseVo);
        out.print(json);
        out.flush();
        out.close();
    }
}
