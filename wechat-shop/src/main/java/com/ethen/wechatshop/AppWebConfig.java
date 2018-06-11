package com.ethen.wechatshop;

import com.ethen.wechatshop.portal.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class AppWebConfig extends WebMvcConfigurerAdapter {


    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     * Description: 注册自定义拦截器
     * Note: 拦截规则
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/", "/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/portal/login")
                .excludePathPatterns("/portal/toLogin")
                .excludePathPatterns("/portal/logout")
                .excludePathPatterns("/portal/toRegister")
                .excludePathPatterns("/portal/register");
    }
}
