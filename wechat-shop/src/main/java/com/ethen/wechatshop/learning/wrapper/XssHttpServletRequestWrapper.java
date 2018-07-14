package com.ethen.wechatshop.learning.wrapper;


import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * description:将http请求参数进行html转义,用以防范XSS
 *
 *
 *
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {


    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getHeader(String name) {
        return StringEscapeUtils.escapeHtml4(super.getHeader(name));
    }


    @Override
    public String getQueryString() {
        return StringEscapeUtils.escapeHtml4(super.getQueryString());
    }


    @Override
    public String getParameter(String name) {
        return StringEscapeUtils.escapeHtml4(super.getParameter(name));
    }


    @Override
    public String[] getParameterValues(String name) {

        String[] values = super.getParameterValues(name);
        if (values != null) {
            int len = values.length;
            String[] escapeValues = new String[len];
            for (int i = 0; i < len; i++) {
                escapeValues[i] = StringEscapeUtils.escapeHtml4(values[i]);
            }
            return escapeValues;
        }

        return super.getParameterValues(name);
    }

}
