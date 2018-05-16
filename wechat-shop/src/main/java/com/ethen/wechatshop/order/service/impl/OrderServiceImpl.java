package com.ethen.wechatshop.order.service.impl;

import com.ethen.wechatshop.order.service.OrderService;
import com.ethen.wechatshop.order.vo.Order;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    SqlSessionTemplate sqlSession;

    @Override
    public Map<String,Object> findOrderList(Object... params) {
        List<Order> orderList = sqlSession.selectList("cms.findOrderList",params);
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("orderList",orderList);
        return retMap;
    }
}
