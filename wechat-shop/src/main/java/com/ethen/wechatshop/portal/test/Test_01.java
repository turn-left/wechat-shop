package com.ethen.wechatshop.portal.test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Test_01 {

    public static void main(String[] args) {
        Date now = new Date(System.currentTimeMillis());
        System.out.println(now.toString());
        Timestamp now2 = new Timestamp(System.currentTimeMillis());
        System.out.println(now2);
        Time now3 = new Time(System.currentTimeMillis());
        System.out.println(now3);
        Map<String,Object> map = new HashMap<>();
        String ts = (String) map.get("dsf");
        if (ts == null) {
            System.out.println(ts);

        } else if ("null".equals(ts)){
            System.out.println("8888888888888888888888888888");
        }
    }

}
