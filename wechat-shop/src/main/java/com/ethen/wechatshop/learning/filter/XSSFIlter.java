package com.ethen.wechatshop.learning.filter;

import com.ethen.wechatshop.learning.wrapper.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * web端防范XSS攻击过滤器demo
 */
public class XSSFIlter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Note:
     *  The <code>doFilter</code> method of the Filter is called by the container
     *  each time a request/response pair is passed through the chain due to a
     *  client request for a resource at the end of the chain. The FilterChain
     *  passed in to this method allows the Filter to pass on the request and
     *  response to the next entity in the chain.
     *
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request),response);
    }

    @Override
    public void destroy() {

    }
}
