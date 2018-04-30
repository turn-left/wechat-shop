package com.ethen.wechatshop.common.service.impl;

import com.ethen.wechatshop.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;



@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    @Override
    public void set(String key, Object value) {
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }




    @Override
    public Object get(String key) {
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
