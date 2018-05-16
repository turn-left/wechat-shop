package com.ethen.wechatshop.order.service;


import java.util.Map;

public interface OrderService {
    Map<String,Object> findOrderList(Object... params);
}
