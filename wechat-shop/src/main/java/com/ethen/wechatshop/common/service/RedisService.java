package com.ethen.wechatshop.common.service;


/**
 * redis简单的功能接口
 * todo 更多接口功能待提供完善...
 *
 */
public interface RedisService {

    public void set(String key, Object value);

    public Object get(String key);

}
