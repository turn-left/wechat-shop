package com.ethen.wechatshop.portal.auth;

import com.ethen.wechatshop.common.ResponseVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtil {

    public static String buildJson(ResponseVo responseVo) {
        try {
            return new ObjectMapper().writeValueAsString(responseVo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
