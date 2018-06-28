package com.ethen.wechatshop.quartz;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,Object> test = new HashMap<>();
        String str = (String) test.get("wer");
        if (StringUtils.isEmpty(str)) {
            System.err.println("hng ...");
        }
    }
}
