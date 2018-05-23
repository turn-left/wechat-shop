package com.ethen.wechatshop.portal.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {


    protected JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse rsp) throws AuthenticationException, IOException, ServletException {

        //json反序列化生成
        AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);

        //返回一个验证令牌
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getUserName(), creds.getPassword()));

    }

    /**
     * 认证成功动作
     * @param req
     * @param rsp
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse rsp, FilterChain chain, Authentication auth) throws IOException, ServletException {
//        super.successfulAuthentication(request, response, chain, authResult);
        TokenAuthenticationService.addAuthentication(rsp, auth.getName());

    }

    /**
     * 验证失败动作
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        ResponseVo<String> responseVo = new ResponseVo<>(500, "Internal Server Error!!!");
        response.getOutputStream().println(ResponseUtil.buildJson(responseVo));
    }
}
